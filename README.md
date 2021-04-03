# Desafio Técnico backend Conexa

Descrição:

Precisamos construir uma API REST onde nossos médicos de plantão consigam agendar atendimentos com pacientes.

Precisamos de uma rota para que médicos da clínica Conexa Saúde consigam realizar login na aplicação:
```
{
  "usuario": "medico@email.com",
  "senha": "senhamedico"
}
```

Onde o response vai ser um token JWT com algumas informações adicionais do médico e seus agendamentos do dia:
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c",
  "medico": "Dr. Daniel Santos",
  "especialidade": "Cardiologia"
  "agendamentos_hoje": [
    {
      "id_paciente": "3u84904",
      "data_hora_atendimento": "2020-08-03 09:00:00",
    },
    {
      "id_paciente": "4903ud3",
      "data_hora_atendimento": "2020-08-03 10:00:00",
    },
  ]
}
```
OBS: A base precisa ter alguns médicos previamente cadastrados;


Também precisamos de uma rota para o médico conseguir realizar logoff:
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}
```
Obs: Após realizado o logoff, token precisa ser invalidado na aplicação para que não seja possível reutilizá-lo novamente. 


Na API também precisamos de um CRUD de pacientes com as seguintes informações:
```
{
  "nome": "Rafael Braga",
  "cpf": "101.202.303-11",
  "idade": "33",
  "telefone": "(21) 3232-6565"
}
```
Obs: A rota de cadastro de pacientes não precisa ser verificada com o token JWT, pois o próprio paciente vai realizar o cadastro através de uma landing page pública na web.

E por fim precisamos de uma rota onde o médico logado realiza agendamento de consulta para um paciente:
```
{
  "data_hora_atendimento": "2020-08-03 09:00:00",
  "id_paciente": "3u84904",
}
```
Após agendamento da consulta, o médico vai ter as informações dos agendamentos dele naquele dia após efetuar o login. 


Requisitos:
* Desenvolva uma aplicação REST utilizando Java 8 e Spring;
* Banco de dados MySQL;
* Clonar este repositório, criar uma nova branch e abrir um merge request para master;


Serão avaliados os seguintes itens:
* Clareza do código;
* Utilizar Java + Spring;
* Se os requisitos descritos acima foram atendidos;
* Se possui descrição clara de como montar o ambiente local e realizar os testes (se houverem);

Em caso de dúvidas sobre o desafio, entre em contato.

Lembre-se que uma boa aplicação é bem testada






