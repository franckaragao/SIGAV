CREATE TABLE fabricante (
	id SERIAL UNIQUE,
	nome character varying(255) NOT NULL,
  	CONSTRAINT fabricante_pk PRIMARY KEY (id)
);

ALTER TABLE veiculo 
	ADD fabricante_id BIGINT NOT NULL;
	
ALTER TABLE veiculo
	ADD origem VARCHAR(50) NOT NULL;
	
ALTER TABLE veiculo
	ADD especie_veiculo VARCHAR(50) NOT NULL;

ALTER TABLE veiculo
	ADD numero_lugares INTEGER;
	
ALTER TABLE veiculo
	ADD horimetro DECIMAL(10) NOT NULL;
	
ALTER TABLE veiculo
	ADD ano_aquisicao INTEGER;
	
	
ALTER TABLE veiculo 
	ADD CONSTRAINT fabricante_id 
	FOREIGN KEY (fabricante_id) 
	REFERENCES fabricante (id) 
	ON DELETE CASCADE;