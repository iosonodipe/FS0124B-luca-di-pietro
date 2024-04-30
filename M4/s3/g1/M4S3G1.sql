-- SELECT *
-- FROM "M4S3G1"."clienti"
-- WHERE "Nome" = 'Mario';

-- SELECT "Nome", "Cognome"
-- FROM "M4S3G1"."clienti"
-- WHERE EXTRACT(YEAR FROM "AnnoDiNascita") = 1982;

-- SELECT "NumeroFattura"
-- FROM "M4S3G1"."fatture"
-- WHERE "Iva" = 20;

-- SELECT *
-- FROM "M4S3G1"."prodotti"
-- WHERE EXTRACT(YEAR FROM "DataAttivazione") = 2017;

-- SELECT *
-- FROM "M4S3G1"."fatture" f
-- INNER JOIN "M4S3G1"."clienti" c ON c."NumeroCliente" = f."idCliente"
-- WHERE "Importo" < 1000



