-- Domain to environments

CREATE DOMAIN public.error_levels
AS character(1)
COLLATE pg_catalog."default"
CONSTRAINT check_error_levels CHECK (VALUE = 'D'::bpchar OR VALUE = 'P'::bpchar OR VALUE = 'H'::bpchar);
ALTER DOMAIN public.error_levels
OWNER TO postgres;
COMMENT ON DOMAIN public.error_levels
IS 'ENVIRONMENTS:  (D)EVELOPMENT(D), (P)RODUCTION(P), (H)OMOLOGATION';

-- Domain to error_levels

CREATE DOMAIN public.error_levels
    AS character(1)
    COLLATE pg_catalog."default"
    CONSTRAINT check_error_levels CHECK (VALUE = 'D'::bpchar OR VALUE = 'W'::bpchar OR VALUE = 'E'::bpchar);
ALTER DOMAIN public.error_levels
    OWNER TO postgres;
COMMENT ON DOMAIN public.error_levels
    IS 'ERROR LEVELS: (D)ebug, (W)arning, (E)rror';

-- Table: tb_log

CREATE TABLE tb_log
(
    id uuid NOT NULL,
    date date,
    description character varying(255) COLLATE pg_catalog."default",
    environment integer,
    error_level character varying(255) COLLATE pg_catalog."default",
    origin character varying(255) COLLATE pg_catalog."default",
    PRIMARY KEY (id)
);

-- Table: tb_user

CREATE TABLE tb_user
(
    id integer NOT NULL,
    enabled smallint,
    password character varying(255) COLLATE pg_catalog."default",
    role character varying(255) COLLATE pg_catalog."default",
    user_email character varying(255) COLLATE pg_catalog."default",
    PRIMARY KEY (id)
);