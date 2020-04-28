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
            name: 'server-book',
            script: 'java',
            args: [
                '-jar',
                'server-book/target/server-book.jar',
                '--spring.profiles.active=local',
                '--server.port=8010'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'server-base',
            script: 'java',
            args: [
                '-jar',
                'server-base/target/server-base.jar',
                '--spring.profiles.active=local',
                '--server.port=8020'
            ],
            cwd: '.',
            interpreter: ''
        },
        {
            name: 'server-admin',
            script: 'java',
            args: [
                '-jar',
                'server-admin/target/server-admin.jar',
                '--server.port=8030'
            ],
            cwd: '.',
            interpreter: ''
        }
    ]
};
