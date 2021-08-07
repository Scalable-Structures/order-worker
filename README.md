### Instruções

Para fazer os testes primeiramente deve instalar  a ferramenta **k6**, nesse [link](https://k6.io/docs/getting-started/installation/) tem as instruções. Se faz necessario também ter instalado o `docker` e `docker-compose` na maquina para subir o ambiente.

### Cenário A

No primeiro cenário, a api está salvando os pedidos direto do banco. Para rodar esse ambiente, no arquivo `docker-compose.yml`, não deve ter a variável `ENABLED_QUEUE` ou ela deve estar com o valor `false` no service **api**, conforme o trecho de exemplo abaixo

```yaml
  api:
    image: gabrielborc/order-api
    restart: on-failure
    environment:
      NODE_ENV: production
      DB_CLIENT: mysql
      DB_HOST: db
      DB_PORT: 3306
      DB_USER: order-worker
      DB_PASSWORD: order-worker
      DB_DATABASE: order
      HOST_QUEUE: queue
      ENABLED_QUEUE: false
```

Depois rode o comando abaixo para subir o ambiente: 

```sh
$ docker-compose up -d
```

E agora rode os teste conforme o exemplo abaixo:

```sh
$ k6 run test/script.k6.js
```

### Cenário B

No segundo cenário, a api está enviando uma mensagem de criação de pedido para o serviço de mensageria, e tem um worker que consome essas mensagem e vai criado os pedidos aos poucos persistindo no banco. Para rodar esse ambiente, no arquivo `docker-compose.yml`, deve ter a variável `ENABLED_QUEUE` e ela deve ter o valor `true` no service **api**, conforme o trecho de exemplo abaixo

```yaml
  api:
    image: gabrielborc/order-api
    restart: on-failure
    environment:
      NODE_ENV: production
      DB_CLIENT: mysql
      DB_HOST: db
      DB_PORT: 3306
      DB_USER: order-worker
      DB_PASSWORD: order-worker
      DB_DATABASE: order
      HOST_QUEUE: queue
      ENABLED_QUEUE: true
```

Depois rode o comando abaixo para subir o ambiente: 

```sh
$ docker-compose up -d
```

E agora rode os teste conforme o exemplo abaixo:

```sh
$ k6 run test/script.k6.js
```