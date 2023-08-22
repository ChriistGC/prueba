CREATE OR REPLACE FUNCTION validate_username(user_name text) RETURNS boolean AS $$
BEGIN
    -- Verificar longitud
    IF LENGTH(user_name) < 8 OR LENGTH(user_name) > 20 THEN
        RETURN FALSE;
    END IF;

    -- Verificar si contiene signos
    IF user_name !~ '^[a-zA-Z0-9]*$' THEN
        RETURN FALSE;
    END IF;

    -- Verificar al menos un número
    IF user_name !~ '[0-9]' THEN
        RETURN FALSE;
    END IF;

    -- Verificar al menos una letra mayúscula
    IF user_name !~ '[A-Z]' THEN
        RETURN FALSE;
    END IF;

    -- Implementa la lógica para verificar duplicados
    IF EXISTS (SELECT 1 FROM usuarios WHERE user_name = user_name) THEN
        RETURN FALSE;
    END IF;

    RETURN TRUE;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION validate_password(password text) RETURNS boolean AS $$
BEGIN
    -- Verificar longitud
    IF LENGTH(password) < 8 THEN
        RETURN FALSE;
    END IF;

    -- Verificar al menos una letra mayúscula
    IF password !~ '[A-Z]' THEN
        RETURN FALSE;
    END IF;

    -- Verificar espacios
    IF password ~ '\s' THEN
        RETURN FALSE;
    END IF;

    -- Verificar al menos un signo (carácter especial)
    IF password !~ '[!@#$%^&*()]' THEN
        RETURN FALSE;
    END IF;

    RETURN TRUE;
END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION validate_identification(identificacion text) RETURNS boolean AS $$
DECLARE
    i integer;
    last_digit text;
    consecutive_count integer := 1;
BEGIN
    -- Verificar longitud
    IF LENGTH(identificacion) <> 10 THEN
        RETURN FALSE;
    END IF;

    -- Verificar solo números
    IF identificacion !~ '^\d+$' THEN
        RETURN FALSE;
    END IF;

    -- Validar que no tenga seguidos 4 números iguales
    last_digit := SUBSTRING(identificacion FROM 1 FOR 1);

    FOR i IN 2..LENGTH(identificacion) LOOP
        IF SUBSTRING(identificacion FROM i FOR 1) = last_digit THEN
            consecutive_count := consecutive_count + 1;

            IF consecutive_count >= 4 THEN
                RETURN FALSE;
            END IF;
        ELSE
            consecutive_count := 1;
            last_digit := SUBSTRING(identificacion FROM i FOR 1);
        END IF;
    END LOOP;

    RETURN TRUE;
END;
$$ LANGUAGE plpgsql;
