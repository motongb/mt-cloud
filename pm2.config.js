module.exports = {
    apps: [
        {
            name: 'mt-cloud-eureka',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-dependency/mt-cloud-eureka/target/mt-cloud-eureka.jar',
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
                'mt-cloud-dependency/mt-cloud-gateway/target/mt-cloud-gateway.jar',
                '--spring.profiles.active=local',
                '--server.port=8080'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-config',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-dependency/mt-cloud-config/target/mt-cloud-config.jar',
                '--eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/',
                '--server.port=8001'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-base',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-center/mt-cloud-base/target/mt-cloud-base.jar',
                '--spring.cloud.config.profile=dev',
                '--server.port=8010'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'mt-cloud-book',
            script: 'java',
            args: [
                '-jar',
                'mt-cloud-center/mt-cloud-book/target/mt-cloud-book.jar',
                '--spring.profiles.active=local',
                '--server.port=8020'
            ],
            cwd: '.',
            interpreter: ''
        }
    ]
};
