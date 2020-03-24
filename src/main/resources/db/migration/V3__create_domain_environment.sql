-- Domain: public.environments

-- DROP DOMAIN public.environments

CREATE DOMAIN public.environments
AS character(1)
COLLATE pg_catalog."default"
CONSTRAINT check_environment CHECK (VALUE = 'D'::bpchar OR VALUE = 'P'::bpchar OR VALUE = 'H'::bpchar);
ALTER DOMAIN public.environments
OWNER TO postgres;
COMMENT ON DOMAIN public.environments
IS 'STAGE: (D)evelopment, (P)roduction, (H)omologation';