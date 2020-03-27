-- Domain: public.error_levels

-- DROP DOMAIN public.error_levels;

CREATE DOMAIN public.error_levels
VARCHAR(90)
COLLATE pg_catalog."default"
CONSTRAINT check_error_levels CHECK (VALUE = 'DEBUG'::bpchar OR VALUE = 'WARNING'::bpchar OR VALUE = 'ERROR'::bpchar);
ALTER DOMAIN public.error_levels
OWNER TO postgres;
COMMENT ON DOMAIN public.error_levels
IS 'ERROR LEVELS: (D)ebug, (W)arning, (E)rror';


-- table log

CREATE TABLE tb_log
(
    id uuid PRIMARY KEY,
    error_level error_levels,
    description character varying(255),
    date date,
    environment character varying(255),
    origin character varying(255)

);

-- table user

CREATE TABLE tb_user
(
     id serial PRIMARY KEY,
     name character varying(255),
     user_email character varying(80),
     password character varying(255),
     role character varying(255),
     enabled smallint
);
