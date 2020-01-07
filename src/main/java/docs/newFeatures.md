**This is a file with new feature which should be implemented**

###### `IN_PROGRESS`
1. Introduce userProfile entity into the system.\
Short description: After registration should be created user in table users and empty userProfile in table UserProfiles.\
UserProfile table should containt with next columns: id, firstName, lastName, jobTitle, province, postalCode, country, city, address, user_id. After registration profile with contain only next fields: firstName, lastName. In same time firstName and lastName should be removed from user entity.
After login user should be able update own userProfile. (FPC-1)

###### `TO_DO`
2. Introduce method in Domain model for converting model into the map <String, Object> (FPC-2)
