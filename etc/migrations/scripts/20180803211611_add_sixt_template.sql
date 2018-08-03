--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // add_sixt_template
-- Migration SQL that makes the change goes here.

insert into template(id, editable, name, text, user_id) values(70,0,"Parkhaus 2.OG SIXT","<script type='text/javascript' src='scripts/parkhaus_sixt.js' ></script>\n", 1);
insert into screen values(80,"",0,70);
insert into course(id, courseMode, name) values(43,0,"Parkhaus 2.OG SIXT");
insert into course_screen values(43,80);

-- //@UNDO
-- SQL to undo the change goes here.


