CREATE TABLE veiculo (
  id bigint NOT NULL,
  descricao character varying(255),
  identificacao character varying(255) NOT NULL,
  CONSTRAINT veiculo_pk PRIMARY KEY (id)
)