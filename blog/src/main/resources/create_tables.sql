create table blog_entry (id bigserial not null,
  blog_data bytea,
  created_by_uid character varying(255) NOT NULL,
  created_time timestamp without time zone,
  modified_by_uid character varying(255) NOT NULL,
  modified_time timestamp without time zone,
  description character varying(512),
  location character varying(255),
  CONSTRAINT blog_entry_pkey PRIMARY KEY (id)
  );

create table entry (
id bigserial not null,
title character varying(255) NOT NULL,
description character varying(255),
heading character varying(255),
locations character varying(512),
activities character varying(512),
travel_date_begin timestamp without time zone,
travel_date_end timestamp without time zone,
created_time timestamp without time zone,
modified_time timestamp without time zone,
thumbnail character varying(255),
constraint entry_pkey PRIMARY KEY (id)
);

create table entry_section(
id bigserial not null,
section_title character varying(255),
section_heading character varying(255),
section_description character varying(255),
section_content character varying(2048),
section_date_begin timestamp without time zone,
section_date_end timestamp without time zone,
created_time timestamp without time zone,
modified_time timestamp without time zone,
entry_id bigserial not null,
constraint entry_fkey FOREIGN KEY (entry_id) REFERENCES entry,
constraint section_pkey PRIMARY KEY (id)
);


create table youtube_video_ids(
id bigserial not null,
entry_section_id bigserial not null,
video_id character varying(512),
video_url character varying(755),
constraint yvi_pkey PRIMARY KEY (id),
constraint entry_section_fkey FOREIGN KEY (entry_section_id) REFERENCES entry_section
);