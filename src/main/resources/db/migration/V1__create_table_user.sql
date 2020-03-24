CREATE TABLE tb_user (
  id uuid NOT NULL,
  registration_date timestamp without time zone DEFAULT now() NOT NULL,
  name character varying(80),
  last_name character varying(80),
  login character varying(80),
  password character varying(80),
  token character varying(80),
  CONSTRAINT tb_user_pkey PRIMARY KEY (id)
)