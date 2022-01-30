--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2022-01-30 19:26:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3180 (class 1262 OID 24710)
-- Name: mpc; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mpc WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';


ALTER DATABASE mpc OWNER TO postgres;

\connect mpc

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3181 (class 0 OID 0)
-- Dependencies: 3180
-- Name: DATABASE mpc; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE mpc IS 'Modulo de Plano de contratação';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 24880)
-- Name: acesso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.acesso (
    id bigint NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE public.acesso OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24885)
-- Name: bairro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bairro (
    id bigint NOT NULL,
    abrev_bairro character varying(255),
    data_registo date,
    nome character varying(255) NOT NULL,
    posto_id bigint NOT NULL
);


ALTER TABLE public.bairro OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 25033)
-- Name: contact_departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact_departamento (
    id bigint NOT NULL,
    num_contacto character varying(255),
    departamento_id bigint NOT NULL
);


ALTER TABLE public.contact_departamento OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24990)
-- Name: contact_instituicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact_instituicao (
    id bigint NOT NULL,
    numero_contacto bigint,
    instituicao_id bigint NOT NULL
);


ALTER TABLE public.contact_instituicao OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 25017)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departamento (
    id bigint NOT NULL,
    abrev_departamento character varying(255) NOT NULL,
    data_registo date,
    nome character varying(255) NOT NULL,
    direcao_id bigint NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 25002)
-- Name: direcao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direcao (
    id bigint NOT NULL,
    abrev_direcao character varying(255) NOT NULL,
    data_registo timestamp without time zone,
    nome character varying(255) NOT NULL,
    instituicao_id bigint NOT NULL
);


ALTER TABLE public.direcao OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24893)
-- Name: distrito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.distrito (
    id bigint NOT NULL,
    abrev_distrito character varying(255),
    data_registo timestamp without time zone,
    nome character varying(255),
    provincia_id bigint NOT NULL
);


ALTER TABLE public.distrito OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24901)
-- Name: fonte_recurso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fonte_recurso (
    id bigint NOT NULL,
    abreviatura character varying(255),
    data_registo date
);


ALTER TABLE public.fonte_recurso OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24906)
-- Name: instituicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instituicao (
    id bigint NOT NULL,
    abrev_instituicao character varying(255),
    casan bigint,
    nome character varying(255) NOT NULL,
    nuit bigint NOT NULL,
    quart bigint,
    rua_id bigint NOT NULL
);


ALTER TABLE public.instituicao OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24914)
-- Name: m_contratacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.m_contratacao (
    id bigint NOT NULL,
    data_registo date,
    descricao character varying(255) NOT NULL
);


ALTER TABLE public.m_contratacao OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 25146)
-- Name: plano_homologado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plano_homologado (
    id bigint NOT NULL,
    ano bigint NOT NULL,
    tipo_plano_homologado character varying(255)
);


ALTER TABLE public.plano_homologado OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 25103)
-- Name: plano_servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plano_servico (
    id bigint NOT NULL,
    final_processo character varying(255) NOT NULL,
    incio_processo character varying(255) NOT NULL,
    data_registo date NOT NULL,
    observacao character varying(255),
    periodo_final character varying(255) NOT NULL,
    periodo_inicial character varying(255) NOT NULL,
    prazo_execucao integer NOT NULL,
    qty integer NOT NULL,
    valor_estimado double precision NOT NULL,
    departamento_id bigint NOT NULL,
    fonterecurso_id bigint NOT NULL,
    mcontratacao_id bigint NOT NULL,
    tipo_id bigint NOT NULL
);


ALTER TABLE public.plano_servico OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24919)
-- Name: posto_admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posto_admin (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL,
    distrito_id bigint NOT NULL
);


ALTER TABLE public.posto_admin OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24924)
-- Name: provincia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provincia (
    id bigint NOT NULL,
    abrev_provincia character varying(255),
    data_resgisto date,
    nome character varying(255)
);


ALTER TABLE public.provincia OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24932)
-- Name: rua; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rua (
    id bigint NOT NULL,
    abrev_rua character varying(255),
    data_registo date,
    nome character varying(255) NOT NULL,
    bairro_id bigint NOT NULL
);


ALTER TABLE public.rua OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24945)
-- Name: seq_acesso; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_acesso
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_acesso OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24947)
-- Name: seq_bairro; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_bairro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_bairro OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24995)
-- Name: seq_contactinstituicao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_contactinstituicao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_contactinstituicao OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 25025)
-- Name: seq_departamento; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_departamento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_departamento OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25010)
-- Name: seq_direcao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_direcao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_direcao OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24949)
-- Name: seq_distrito; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_distrito
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_distrito OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24951)
-- Name: seq_fonte_recurso; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_fonte_recurso
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_fonte_recurso OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 24953)
-- Name: seq_instituicao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_instituicao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_instituicao OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24955)
-- Name: seq_mcontratacao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_mcontratacao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_mcontratacao OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 25136)
-- Name: seq_plano_homologado; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_plano_homologado
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_plano_homologado OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 25053)
-- Name: seq_plano_servico; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_plano_servico
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_plano_servico OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24957)
-- Name: seq_posto_admin; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_posto_admin
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_posto_admin OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24959)
-- Name: seq_provincia; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_provincia
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_provincia OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24961)
-- Name: seq_rua; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_rua
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_rua OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24963)
-- Name: seq_tipo; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_tipo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_tipo OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 25166)
-- Name: seq_usuario; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_usuario OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 25038)
-- Name: seqcontact_departamento; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seqcontact_departamento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seqcontact_departamento OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24940)
-- Name: tipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo (
    id bigint NOT NULL,
    nome_tipo character varying(255)
);


ALTER TABLE public.tipo OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 25151)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id bigint NOT NULL,
    data_actual_senha date,
    login character varying(255),
    senha character varying(255)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 25159)
-- Name: usuario_acesso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_acesso (
    usuario_id bigint NOT NULL,
    acesso_id bigint NOT NULL
);


ALTER TABLE public.usuario_acesso OWNER TO postgres;

--
-- TOC entry 2960 (class 2606 OID 24884)
-- Name: acesso acesso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acesso
    ADD CONSTRAINT acesso_pkey PRIMARY KEY (id);


--
-- TOC entry 2962 (class 2606 OID 24892)
-- Name: bairro bairro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT bairro_pkey PRIMARY KEY (id);


--
-- TOC entry 2986 (class 2606 OID 25037)
-- Name: contact_departamento contact_departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_departamento
    ADD CONSTRAINT contact_departamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2980 (class 2606 OID 24994)
-- Name: contact_instituicao contact_instituicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_instituicao
    ADD CONSTRAINT contact_instituicao_pkey PRIMARY KEY (id);


--
-- TOC entry 2984 (class 2606 OID 25024)
-- Name: departamento departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2982 (class 2606 OID 25009)
-- Name: direcao direcao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direcao
    ADD CONSTRAINT direcao_pkey PRIMARY KEY (id);


--
-- TOC entry 2964 (class 2606 OID 24900)
-- Name: distrito distrito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_pkey PRIMARY KEY (id);


--
-- TOC entry 2966 (class 2606 OID 24905)
-- Name: fonte_recurso fonte_recurso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fonte_recurso
    ADD CONSTRAINT fonte_recurso_pkey PRIMARY KEY (id);


--
-- TOC entry 2968 (class 2606 OID 24913)
-- Name: instituicao instituicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instituicao
    ADD CONSTRAINT instituicao_pkey PRIMARY KEY (id);


--
-- TOC entry 2970 (class 2606 OID 24918)
-- Name: m_contratacao m_contratacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.m_contratacao
    ADD CONSTRAINT m_contratacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2990 (class 2606 OID 25150)
-- Name: plano_homologado plano_homologado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_homologado
    ADD CONSTRAINT plano_homologado_pkey PRIMARY KEY (id);


--
-- TOC entry 2988 (class 2606 OID 25110)
-- Name: plano_servico plano_servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_servico
    ADD CONSTRAINT plano_servico_pkey PRIMARY KEY (id);


--
-- TOC entry 2972 (class 2606 OID 24923)
-- Name: posto_admin posto_admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posto_admin
    ADD CONSTRAINT posto_admin_pkey PRIMARY KEY (id);


--
-- TOC entry 2974 (class 2606 OID 24931)
-- Name: provincia provincia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provincia
    ADD CONSTRAINT provincia_pkey PRIMARY KEY (id);


--
-- TOC entry 2976 (class 2606 OID 24939)
-- Name: rua rua_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rua
    ADD CONSTRAINT rua_pkey PRIMARY KEY (id);


--
-- TOC entry 2978 (class 2606 OID 24944)
-- Name: tipo tipo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo
    ADD CONSTRAINT tipo_pkey PRIMARY KEY (id);


--
-- TOC entry 2994 (class 2606 OID 25165)
-- Name: usuario_acesso unique_acesso_user; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_acesso
    ADD CONSTRAINT unique_acesso_user UNIQUE (usuario_id, acesso_id);


--
-- TOC entry 2992 (class 2606 OID 25158)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 3008 (class 2606 OID 25168)
-- Name: usuario_acesso acesso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_acesso
    ADD CONSTRAINT acesso_fk FOREIGN KEY (acesso_id) REFERENCES public.acesso(id);


--
-- TOC entry 2999 (class 2606 OID 24985)
-- Name: rua bairro_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rua
    ADD CONSTRAINT bairro_fk FOREIGN KEY (bairro_id) REFERENCES public.bairro(id);


--
-- TOC entry 3003 (class 2606 OID 25040)
-- Name: contact_departamento departamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_departamento
    ADD CONSTRAINT departamento_fk FOREIGN KEY (departamento_id) REFERENCES public.departamento(id);


--
-- TOC entry 3004 (class 2606 OID 25111)
-- Name: plano_servico departamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_servico
    ADD CONSTRAINT departamento_fk FOREIGN KEY (departamento_id) REFERENCES public.departamento(id);


--
-- TOC entry 3002 (class 2606 OID 25027)
-- Name: departamento direcao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT direcao_fk FOREIGN KEY (direcao_id) REFERENCES public.direcao(id);


--
-- TOC entry 2998 (class 2606 OID 24980)
-- Name: posto_admin distrito_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posto_admin
    ADD CONSTRAINT distrito_fk FOREIGN KEY (distrito_id) REFERENCES public.distrito(id);


--
-- TOC entry 3001 (class 2606 OID 25012)
-- Name: direcao fk8kfwg08r9ka4g9s0kh2stc6ra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direcao
    ADD CONSTRAINT fk8kfwg08r9ka4g9s0kh2stc6ra FOREIGN KEY (instituicao_id) REFERENCES public.instituicao(id);


--
-- TOC entry 3005 (class 2606 OID 25116)
-- Name: plano_servico fonterecurso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_servico
    ADD CONSTRAINT fonterecurso_fk FOREIGN KEY (fonterecurso_id) REFERENCES public.fonte_recurso(id);


--
-- TOC entry 3000 (class 2606 OID 24997)
-- Name: contact_instituicao instituicao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_instituicao
    ADD CONSTRAINT instituicao_fk FOREIGN KEY (instituicao_id) REFERENCES public.instituicao(id);


--
-- TOC entry 3006 (class 2606 OID 25121)
-- Name: plano_servico mcontratacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_servico
    ADD CONSTRAINT mcontratacao_fk FOREIGN KEY (mcontratacao_id) REFERENCES public.m_contratacao(id);


--
-- TOC entry 2995 (class 2606 OID 24965)
-- Name: bairro posto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT posto_fk FOREIGN KEY (posto_id) REFERENCES public.posto_admin(id);


--
-- TOC entry 2996 (class 2606 OID 24970)
-- Name: distrito provincia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT provincia_fk FOREIGN KEY (provincia_id) REFERENCES public.provincia(id);


--
-- TOC entry 2997 (class 2606 OID 24975)
-- Name: instituicao rua_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instituicao
    ADD CONSTRAINT rua_fk FOREIGN KEY (rua_id) REFERENCES public.rua(id);


--
-- TOC entry 3007 (class 2606 OID 25126)
-- Name: plano_servico tipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plano_servico
    ADD CONSTRAINT tipo_fk FOREIGN KEY (tipo_id) REFERENCES public.tipo(id);


--
-- TOC entry 3009 (class 2606 OID 25173)
-- Name: usuario_acesso usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_acesso
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


-- Completed on 2022-01-30 19:26:52

--
-- PostgreSQL database dump complete
--

