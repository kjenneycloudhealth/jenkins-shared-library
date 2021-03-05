def call(int buildTimeout) {
    node() {
      stages {
        stage('Prepare') {
          timeout(time: buildTimeout, unit: 'MINUTES') {
            steps {
              echo "test this"
            }
          }
        }
      }
    }
}
