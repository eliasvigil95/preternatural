INSERT INTO USER_ROLES (TITLE) VALUES ('User');
INSERT INTO USER_ROLES (TITLE) VALUES ('Moderator');
INSERT INTO USER_ROLES (TITLE) VALUES ('Admin');

INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Protagonist');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Deuteragonist');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Antagonist');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Secondary');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Love Interest');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Tertiary');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Mentor');
INSERT INTO CHARACTER_ROLES (TITLE) VALUES ('Flat');

INSERT INTO SPECIES (SPECIES_NAME) VALUES ('Human');
INSERT INTO SPECIES (SPECIES_NAME) VALUES ('Preterhuman');

INSERT INTO STAGES (STAGE_ID, STAGE_NAME) VALUES (-1, 'None');
INSERT INTO STAGES (STAGE_ID, STAGE_NAME) VALUES (0, 'Unmanifested');
INSERT INTO STAGES (STAGE_NAME) VALUES ('Basic');
INSERT INTO STAGES (STAGE_NAME) VALUES ('Intermediate');
INSERT INTO STAGES (STAGE_NAME) VALUES ('Advanced');
INSERT INTO STAGES (STAGE_NAME) VALUES ('Expert');


INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, USERNAME, PASS, ROLE_ID) VALUES ('Elias', 'Vigil', 'elias.vigil@mailinator.com', 'Vigilante', 'PreternaturalFan', 1);

INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Jason', 'Gray', 1, 'Jason is a high school senior whose powers have just manifested. Unable to control them, he has a reputation of being a thief and a compulsive liar.', 2, 18, 1);  
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Collin', 'Gray', 6, 'Collin is a junior in high school and is Jason''s younger brother. He''s also the Captain of the school''s soccer team, which makes him considerably more popular than his older brother.', 2, 16, 0);
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Meghan', 'Gray', 6, 'Meghan is Jason''s mother. She has been raising her two boys, Jason and Collin, by herself since her husband Shawn left her 15 years ago.', 1, 45, -1);
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Shawn', 'Gray', 6, 'Shawn is Jason''s father. He left his family 15 years ago after moving them to a new place. He has not been heard from since then and is presumed to be dead.', 2, 55, 4); 
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Hartley', 'Sinclair', 5, 'Hartley ran away from home after her powers manifested. She is 3rd-in-command in the Reformation.', 2, 19, 2); 
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Roderick', 'Sinclair', 8, 'Roderick is Hartley''s father.', 1, 50, -1);
INSERT INTO CHARACTERS (FIRST_NAME, LAST_NAME, CHAR_ROLE_ID, DESCRIPTION, SPECIES_ID, AGE, STAGE_ID) VALUES ('Madelyn', 'Sinclair', 8, 'Madelyn is Hartley''s mother.', 1, 47, -1);
 
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Telekinesis', 'The ability to move objects without touching them.', 1);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Teleportation', 'The ability to send objects from one place to another.', 1);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Sensing', 'The ability to perceive objects.', 1);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Creation', 'The ability to manifest objects out of thin air.', 2);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Repair', 'The ability to fix broken objects.', 2);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Disintegration', 'The ability to deconstruct objects.', 2);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Form', 'The ability to transform the body into inorganic materials', 3);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Aging', 'The ability to alter the age of objects.', 3);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Override', 'The ability to assume control of complex objects.', 3);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Merging', 'The ability to pass through solid objects.', 4);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Sizing', 'The ability to change the size of objects.', 4);
INSERT INTO POWERS (POWER_NAME, POWER_DESCRIPTION, STAGE_ID) VALUES ('Object Conversion Touch', 'The ability to change solid and liquid matter into inorganic materials.', 4);
