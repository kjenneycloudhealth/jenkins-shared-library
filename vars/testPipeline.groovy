def call(int buildTimeout) {
    node() {
      stage('Prepare') {
        timeout(time: buildTimeout, unit: 'MINUTES') {
          steps {
            echo "test this"
          }
        }
      }
    }
}
