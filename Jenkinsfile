def defaults = [:]
defaults['version'] = '0.0.2'
def version = params.version == null ? defaults['version'] : params.version

def label = "worker-${UUID.randomUUID().toString()}"
def SERVICE_NAME = "map-supplier"
def CODE_REPO = "repo.surf.advisor"
def dockerhubUser = "surfadvisor"
def registry = "${dockerhubUser}/${SERVICE_NAME}"
def registryCredential = 'dockerhub'
def REPOSITORY_TAG="${registry}:${version}"
def dockerImage = ''

podTemplate(label: label, serviceAccount: 'jenkins-stg', containers: [
  containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.16.0', command: 'cat', ttyEnabled: true)
],
volumes: [
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
]) {

  node(label) {
    parameters {
       string(defaultValue: defaults['version'], description: 'Dictionary version?', name: 'version')
    }

    stage('Clone git') {
          git credentialsId: 'jenkins-github', url: "https://github.com/surfadvisor/map-supplier"
    }

    stage('Download .jar from S3') {
          withAWS(region: 'eu-central-1', credentials: 'aws-code-ro-access') {
           s3Download(file:'app.jar', bucket:"${CODE_REPO}", path:"release/com/surf/advisor/map/supplier/map-supplier/${version}/map-supplier-${version}.jar", force:true)
          }
          sh 'chmod +x app.jar'
          sh 'ls -al'
    }

    stage('Build image') {
         container('docker') {
           script {
             dockerImage = docker.build("${REPOSITORY_TAG}")
             docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
             }
           }
         }
    }

    stage('Deploy to Cluster') {
        container('kubectl') {
          sh "sed -ri 's/^(\\s*)(image\\s*:\\s*<X>\\s*\$)/\\1image: ${dockerhubUser}\\/${SERVICE_NAME}:${version}/' ${WORKSPACE}/deploy.yaml"
          sh 'kubectl apply -f ${WORKSPACE}/deploy.yaml'
        }
    }
  }
}
