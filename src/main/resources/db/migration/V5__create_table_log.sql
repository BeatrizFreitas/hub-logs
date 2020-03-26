CREATE TABLE tb_log (
  id uuid NOT NULL,
  occurrence_date timestamp without time zone DEFAULT now() NOT NULL,
  error_level error_levels,
  description character varying(255),
  origin character varying(80),
  frequency integer,
  environment environments,
  CONSTRAINT tb_log_pkey PRIMARY KEY (id)
)