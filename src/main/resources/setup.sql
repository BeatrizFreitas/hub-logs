-- Domain: public.environments

-- DROP DOMAIN public.environments

CREATE DOMAIN public.environments
AS character(1)
COLLATE pg_catalog."default"
CONSTRAINT check_environment CHECK (VALUE = 'D'::bpchar OR VALUE = 'P'::bpchar OR VALUE = 'H'::bpchar);
ALTER DOMAIN public.environments
OWNER TO postgres;
COMMENT ON DOMAIN public.environments
IS 'Environments: (D)evelopment, (P)roduction, (H)omologation';

-- Domain: public.error_levels

-- DROP DOMAIN public.error_levels;

CREATE DOMAIN public.error_levels
AS character(1)
COLLATE pg_catalog."default"
CONSTRAINT check_error_levels CHECK (VALUE = 'D'::bpchar OR VALUE = 'W'::bpchar OR VALUE = 'E'::bpchar);
ALTER DOMAIN public.error_levels
OWNER TO postgres;
COMMENT ON DOMAIN public.error_levels
IS 'ERROR LEVELS: (D)ebug, (W)arning, (E)rror';

-- table log

CREATE TABLE tb_log
(
    id uuid NOT NULL,
    error_level error_levels,
    description character varying(255),
    date timestamp,
    origin character varying(80),
    environment environments,
    PRIMARY KEY (id)
);

-- table user

CREATE TABLE tb_user
(
     id bigint NOT NULL,
     name character varying(80),
     user_email character varying(80),
     password character varying(80),
     role character varying(80),
     enabled smallint,

    PRIMARY KEY (id)
)
