create table blog_entry (id bigserial not null,
  blog_data bytea,
  created_by_uid character varying(255) NOT NULL,
  created_time timestamp without time zone,
  modified_by_uid character varying(255) NOT NULL,
  modified_time timestamp without time zone,
  description character varying(512),
  location character varying(255)
  CONSTRAINT blog_entry_pkey PRIMARY KEY (id)
  );