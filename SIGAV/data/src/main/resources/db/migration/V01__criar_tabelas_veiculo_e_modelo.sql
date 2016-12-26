CREATE TABLE veiculo (
	id SERIAL UNIQUE,
	descricao character varying(255),
  	identificacao character varying(255) NOT NULL,
  	CONSTRAINT veiculo_pk PRIMARY KEY (id)
)