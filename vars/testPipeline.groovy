def call(int buildTimeoutMinutes) {
  pipeline {
      agent any
      options {
          timeout(time: buildTimeoutMinutes, unit: 'MINUTES')
      }
      stages {
          stage('Example') {
              steps {
                  echo 'Hello World'
              }
          }
      }
  }
}
