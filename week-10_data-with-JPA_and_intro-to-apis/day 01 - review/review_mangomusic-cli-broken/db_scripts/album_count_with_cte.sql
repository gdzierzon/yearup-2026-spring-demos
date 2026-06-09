# CTE = Common Table Expression
WITH ranked_genre_plays_cte AS
(
    SELECT ar.primary_genre AS genre
        , a.title AS album_title
        , ar.name AS artist
        , COUNT(ap.play_id) AS play_count
        , ROW_NUMBER() OVER (
        PARTITION BY primary_genre
        ORDER BY COUNT(ap.play_id) DESC
        ) AS genre_rank
    FROM album_plays AS ap
    INNER JOIN albums AS a
        ON ap.album_id = a.album_id
    INNER JOIN artists AS ar
        ON a.artist_id = ar.artist_id
    WHERE completed = 1
    GROUP BY genre
        , album_title
        , artist
    ORDER BY genre
        , play_count DESC
)
SELECT *
FROM ranked_genre_plays_cte
WHERE genre_rank <= 5;


SELECT *
FROM ranked_genre_plays_cte
WHERE genre_rank <= 5;


