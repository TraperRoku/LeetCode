SELECT Signups.user_id, ROUND(AVG(CASE WHEN action = 'confirmed' THEN 1 else 0 END),2) as confirmation_rate
from Signups LEFT JOIN Confirmations on Signups.user_id = Confirmations.user_id
group by Signups.user_id