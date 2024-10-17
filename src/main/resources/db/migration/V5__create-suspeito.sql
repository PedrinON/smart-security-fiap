CREATE SEQUENCE SEQ_SUSPEITO
START WITH 1
INCREMENT BY 1
MINVALUE 0
NOCACHE
NOCYCLE
;

CREATE TABLE TB_SUSPEITO (
    ID_SUSPEITO INTEGER DEFAULT SEQ_SUSPEITO.NEXTVAL NOT NULL,
    NOME VARCHAR(100) NOT NULL,
    IDADE INTEGER NOT NULL,
    GENERO VARCHAR(10) NOT NULL,
    DESCRICAO VARCHAR(500) NOT NULL
);