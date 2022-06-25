pipeline{
    agent {
        docker {
            image 'gradle:4.9.0-jdk8'
        }
    }

    stages{
        stage("Build"){
            steps{
                configFileProvider([configFile(fileId: 'hibernate-cfg-twittercitymod', targetLocation: 'src/main/resources/assets/tc/hibernate.cfg.xml')]) {}  
                sh 'gradle clean build -g gradle-user-home'
            }
        }
    

        stage("Deploy"){
            steps{
                withCredentials([sshUserPrivateKey(credentialsId: 'okeanos-server-ssh', keyFileVariable: 'keyfile', passphraseVariable: '', usernameVariable: 'username')]) {
                    sh "scp -i ${keyfile} -o StrictHostKeyChecking=no build/libs/twittercity-1.0.jar ${username}@twittercity.bravecode.gr:/home/${username}/twittercity-services/minecraft-forge-server/data/mods/twittercity-1.0.jar"
                    sh "ssh -i ${keyfile} -o StrictHostKeyChecking=no ${username}@twittercity.bravecode.gr docker exec twitter_city_minecraft_server rcon-cli stop"
                }
            }
        }
    }
}