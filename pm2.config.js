module.exports = {
    apps: [
        {
            name: 'server-eureka',
            script: 'java',
            args: [
                '-jar',
                'server-eureka/target/server-eureka.jar',
                '--server.port=8000'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'server-gateway',
            script: 'java',
            args: [
                '-jar',
                'server-gateway/target/server-gateway.jar',
                '--spring.profiles.active=local',
                '--server.port=8080'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'server-provide1',
            script: 'java',
            args: [
                '-jar',
                'server-provide1/target/server-provide1.jar',
                '--spring.profiles.active=local',
                '--server.port=8010'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'server-provide2-file',
            script: 'java',
            args: [
                '-jar',
                'server-provide2/target/server-provide2.jar',
                '--spring.profiles.active=local',
                '--server.port=8020'
            ],
            cwd: '.',
            interpreter: ''
        }
    ]
};
