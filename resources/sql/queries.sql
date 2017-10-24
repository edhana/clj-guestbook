--name:save-message!
-- creates a new message
INSERT INTO guestbook
(name, mesasge, timestamp)
VALUES (:name, :message, :timestamp)

--name:get-messages
-- selects all available messages
SELECT * from guestbook
