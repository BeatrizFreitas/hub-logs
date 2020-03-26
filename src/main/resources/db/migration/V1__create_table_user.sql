CREATE TABLE tb_user (
  id uuid NOT NULL,
  registration_date timestamp without time zone DEFAULT now() NOT NULL,
  user_name character varying(80),
  user_email character varying(80),
  password character varying(80),
  CONSTRAINT tb_user_pkey PRIMARY KEY (id)
)