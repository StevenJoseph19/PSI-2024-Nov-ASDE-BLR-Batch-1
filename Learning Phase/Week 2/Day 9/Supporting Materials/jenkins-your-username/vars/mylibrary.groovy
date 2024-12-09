def checkoutCode(String branch, String repoUrl, String credentialsId) {
    echo "Checking out branch ${branch} from ${repoUrl}..."
    git branch: branch, url: repoUrl, credentialsId: credentialsId
}

def buildApplication(String directory, String args) {
    dir(directory) {
        echo "Building application in ${directory} with args: ${args}..."
        sh "mvn clean install ${args}"
    }
}

def runTests(String directory) {
    dir(directory) {
        echo "Running tests in ${directory}..."
        sh 'mvn test'
    }
}

def archiveArtifactsStep(String directory, String pattern) {
    dir(directory) {
        echo "Archiving artifacts matching pattern ${pattern}..."
        archiveArtifacts artifacts: pattern, fingerprint: true
    }
}
