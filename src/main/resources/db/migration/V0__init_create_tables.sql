CREATE TABLE IF NOT EXISTS public.gcd_task
(
    identifier uuid PRIMARY KEY,
    n1_param   integer NOT NULL,
    n2_param   integer NOT NULL,
    result     integer,
    status     text    NOT NULL
);

CREATE TABLE IF NOT EXISTS public.calculation
(
    id       serial PRIMARY KEY,
    n1_param integer NOT NULL,
    n2_param integer NOT NULL,
    result   integer NOT NULL,

    UNIQUE (n1_param, n2_param)
);