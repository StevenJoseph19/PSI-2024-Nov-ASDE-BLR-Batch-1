CREATE DATABASE IF NOT EXISTS loboticket;

USE loboticket;

create table Venues
(
    Id       Int PRIMARY KEY AUTO_INCREMENT,
    Name     varchar(100)    not null,
    Capacity Int             not null
);

create table Acts
(
    Id          Int PRIMARY KEY AUTO_INCREMENT,
    Name        TEXT            not null,
    RecordLabel TEXT            null
);

create table Gigs
(
    Id          Int PRIMARY KEY AUTO_INCREMENT,
    VenueId     Int           not null,
    ActId       Int           not null,
    TicketsSold Int           not null,
    Price       decimal(4, 2) not null,
    Date        Date          not null,

    FOREIGN KEY (VenueId) REFERENCES Venues (Id),
    FOREIGN KEY (ActId) REFERENCES Acts (Id)
);

INSERT INTO Venues (Id, Name, Capacity)
Values (1, 'The Arena', 100);
INSERT INTO Venues (Id, Name, Capacity)
Values (2, 'The Bowl', 150);
INSERT INTO Venues (Id, Name, Capacity)
Values (3, 'The Garage', 200);
INSERT INTO Venues (Id, Name, Capacity)
Values (4, 'The Yard', 20);

INSERT INTO Acts (Id, Name, RecordLabel)
VALUES (1, 'Foo Feathers', 'Copitol');
INSERT INTO Acts (Id, Name, RecordLabel)
VALUES (2, 'The Bottles', 'Banana');
INSERT INTO Acts (Id, Name)
VALUES (3, 'BAAB');
INSERT INTO Acts (Id, Name)
VALUES (4, 'Alede');
INSERT INTO Acts (Id, Name)
VALUES (5, 'Dana Lead Rey');
INSERT INTO Acts (Id, Name)
VALUES (6, 'Led Balloon');
INSERT INTO Acts (Id, Name)
VALUES (7, 'Sheryl Rook');



INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 1, 10.5, 90, '2022-11-04');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 1, 10.5, 110, '2022-11-05');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 1, 10.5, 170, '2022-11-06');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 1, 10.5, 20, '2022-11-08');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 2, 12.99, 91, '2022-11-05');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 2, 12.99, 113, '2022-11-04');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 3, 4.99, 153, '2022-11-07');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 4, 4.99, 10, '2022-11-04');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 5, 14.99, 153, '2022-11-06');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 5, 14.99, 101, '2022-11-10');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 6, 14.99, 153, '2022-11-07');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 6, 14.99, 101, '2022-11-09');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 6, 9.99, 20, '2022-11-05');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 7, 15.99, 150, '2022-11-08');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 7, 15.5, 101, '2022-11-04');
