# Ninja Gold

1. Store information for gold count
2. Store activities - earned x gold or lost x gold
3. 1 Get 1 Post method
4. 4 Post forms all to same post request - farm, cave, house, quest
5. After post request - redirect - same page (index) only 1 jsp file is needed
6. reset button

7. spa - looses gold only
8. prison - new jsp if count falls too low they go there.


## post request job's
1. way to determine what button was clicked - to know how much to add/remove
2. get random number (range determined from step 1)
3. gold count stored in session
4. store / update activities
5. add/remove random number to gold count


## get request
1. if session.gold is null = set to 0
2. if !null do nothing

## reset method
1. clear session