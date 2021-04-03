select * from players;
desc players;
update players set bal = 100;
truncate table players;
select * from stocks;
select * from items;
select f.fname Item_name, (f.price + f.price*0.3) selling_price, s.amount from items f, stocks s where f.fid = s.fid;
select * from stocks where fid = 2;