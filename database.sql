-- -------------------------------------------------------------
-- TablePlus 3.12.0(354)
--
-- https://tableplus.com/
--
-- Database: springer
-- Generation Time: 2020-12-09 16:49:20.7410
-- -------------------------------------------------------------


DROP TABLE IF EXISTS "public"."identities";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS identities_id_seq;

-- Table Definition
CREATE TABLE "public"."identities" (
    "id" int4 NOT NULL DEFAULT nextval('identities_id_seq'::regclass),
    "email" varchar(255) NOT NULL,
    "name" varchar(255) NOT NULL,
    "password" varchar(255) NOT NULL,
    PRIMARY KEY ("id")
);

INSERT INTO "public"."identities" ("id", "email", "name", "password") VALUES
('1', 'herujokoutomo@gmail.com', 'Heru', '$2a$10$TKqHUEetWDx5EmAtIeM6FeX5cTyhQIiMKgR.hr3pvgu4LSmQhp7Eq');
