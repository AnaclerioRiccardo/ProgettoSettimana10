PGDMP                         z            piattaformafilm    14.1    14.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    33116    piattaformafilm    DATABASE     k   CREATE DATABASE piattaformafilm WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE piattaformafilm;
                postgres    false            �            1259    33118    film    TABLE     �   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            �            1259    33117    film_id_seq    SEQUENCE     �   CREATE SEQUENCE public.film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.film_id_seq;
       public          postgres    false    210            �           0    0    film_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.film_id_seq OWNED BY public.film.id;
          public          postgres    false    209            \           2604    33121    film id    DEFAULT     b   ALTER TABLE ONLY public.film ALTER COLUMN id SET DEFAULT nextval('public.film_id_seq'::regclass);
 6   ALTER TABLE public.film ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            �          0    33118    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   �
       �           0    0    film_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.film_id_seq', 3, true);
          public          postgres    false    209            ^           2606    33125    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            �   �   x�E̱�0 ���S�*iN1�h��!w���mNC��6-o�f�Ə��1��/���ڭӐ�]�u�h��L�:��)�4c�F�;���=.mT�y �J�LV
�i�������wz&�ز��H'����3;,���P�����..�đפ���6��.�0�2�V��hTVA"{L��B���<X     