Feature: login

    Scenario: Fazer login
        Given  que estou na pagina de login
        And que preencho o username valido
        And que preencho a senha valida
        When clico em login
        Then  devo visualizar uma mensagem de boas vindas

    Scenario: Tentar fazer login com campos incorretos
        Given que estou na pagina de login
        And que preencho um username invalido
        And que preencho a senha valida
        When clico em login
        Then devo visualizar uma mensagem de login invalido

    Scenario: Tentar fazer login com senha incorreta
        Given que estou na pagina de login
        And que preencho o username valido
        And que preencho a senha invalida
        When clico em login
        Then devo visualizar uma mensagem de login invalido


