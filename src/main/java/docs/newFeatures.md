**This is a file with new feature which should be implemented**

1. Introduce userProfile entity into the system.\
Short description: After registration should be created user in table users and empty userProfile in table UserProfiles.\
UserProfile table should containt with next columns: id, firstName, lastName, jobTitle, province, postalCode, country, city, address, user_id. After registration profile with contain only next fields: firstName, lastName. In same time firstName and lastName should be removed from user entity.
After login user should be able update own userProfile.
2. Introduce Transaction entity into the system. After withdrawal deposit balance should be created WithdrawalTransaction. After reinforcement of deposit should be created DepositTransaction.
Notes: Will be implementd at least 3 more transaction types. Think about needed fields before zoom call.