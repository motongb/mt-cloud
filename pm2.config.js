module.exports = {
    apps: [
        {
            name: 'mt-cloud-eureka',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-eureka/target/mt-cloud-eureka.jar',
                '--server.port=8000'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-gateway',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-gateway/target/mt-cloud-gateway.jar',
                '--spring.profiles.active=local',
                '--server.port=8080'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-book',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-book/target/mt-cloud-book.jar',
                '--spring.profiles.active=local',
                '--server.port=8010'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-base',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-base/target/mt-cloud-base.jar',
                '--spring.profiles.active=local',
                '--server.port=8020'
            ],
            cwd: '.',
            interpreter: ''
        }
    ]
};
