# StatsScraper

App to scrape personal statistics of a player from www.ceskyflorbal.cz

REST endpoints:
* http://localhost:8080/player/scrape/{playerID} - scrapes statistics for {playerID} and stores them in list
* http://localhost:8080/player/all - returns JSON object with lifetime statistics of player scraped previously
* http://localhost:8080/player/superleague - returns JSON object with complete Livesport Superleague statistics of player scraped previously

Exception are currently not handled, use correct ID (ten digits number)
