INSERT INTO usuario (codigo, email, especialidade, medico, nome, senha) values (1,  'joao@email.com', 'Clínica médica, Parasitologia', true,'João Silva', '$2a$10$06CtZ90At5sGyyNI2NYVo.Ay6oe55Qglr5cd6rKDPU.TpcLHRzPO2');
INSERT INTO usuario (codigo, email, especialidade, medico, nome, senha) values (2,  'hans@email.com', 'Cirurgia geral', true, 'DR Hans Chucrute','$2a$10$06CtZ90At5sGyyNI2NYVo.Ay6oe55Qglr5cd6rKDPU.TpcLHRzPO2');

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_AGENDAMENTO');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_AGENDAMENTO');


-- joão
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);


-- hans
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);

commit;