SELECT *
FROM artists;

SELECT *
FROM users;

SELECT count(*)
FROM album_plays
WHERE completed != 1;

# genre, albums and play_count
SELECT ar.primary_genre AS genre
     , count(distinct a.album_id) AS album_count
FROM album_plays AS ap
INNER JOIN albums AS a ON ap.album_id = a.album_id
        AND ap.completed = 1
INNER JOIN artists AS ar ON a.artist_id = ar.artist_id
GROUP BY genre
HAVING count(DISTINCT a.album_id) >= 5
ORDER BY genre
;


WITH ranked_songs AS (
    SELECT ar.primary_genre  AS genre
       , a.title           as album_title
       , count(ap.play_id) AS play_count
       , ROW_NUMBER() over (
            PARTITION BY ar.primary_genre
            ORDER BY count(ap.play_id) DESC
        ) as genre_rank
    FROM album_plays AS ap
           INNER JOIN albums AS a ON ap.album_id = a.album_id
           INNER JOIN artists AS ar ON a.artist_id = ar.artist_id
    GROUP BY genre
         , album_title
    ORDER BY genre
         , play_count DESC)
SELECT *
FROM ranked_songs
# where genre_rank <=5
;
