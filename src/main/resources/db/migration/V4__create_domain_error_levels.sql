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