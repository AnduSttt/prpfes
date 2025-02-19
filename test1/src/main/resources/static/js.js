async function GetEmpl() {
    try {
        const response = await fetch("http://localhost:8080/api/v1/employee/AllEmpl");
        const empl = await response.json();
        return empl;
    } catch (error) {
        console.error(error);
        return [];
    }
}

async function GetPosition(idPos) {
    try {
        const res = await fetch("http://localhost:8080/api/v1/GetPosition/" + idPos);
        const pos = await res.json();
        return pos;
    } catch (error) {
        console.log(error);
        return [];
    }
}

function CreateCardEmpl(empl, Pos) {

    const FI = document.createElement("h1");
    const O = document.createElement("h1");
    const EmplDiv = document.createElement("div");
    FI.textContent = empl.surname + " " + empl.name;
    O.textContent = empl.patronymic;

    const Email = document.createElement("p");
    Email.textContent = empl.corporateEmail;
    Email.classList.add("email");
    const Position = document.createElement("p");
    Position.textContent = Pos.positionName;
    const DateRoshd = new Date(empl.birthday);

    let month;
    switch (DateRoshd.getMonth()) {
        case 0:
            month = "Января";
            break;
        case 1:
            month = "Февраля";
            break;
        case 2:
            month = "Марта";
            break;
        case 3:
            month = "Апреля";
            break;
        case 4:
            month = "Мая";
            break;
        case 5:
            month = "Июня";
            break;
        case 6:
            month = "Июля";
            break;
        case 7:
            month = "Августа";
            break;
        case 8:
            month = "Сентября";
            break;
        case 9:
            month = "Октября";
            break;
        case 10:
            month = "Ноября";
            break;
        case 11:
            month = "Декабря";
            break;

        default:

            break;
    }

    const day = document.createElement("p");
    day.textContent = DateRoshd.getDate() + " " + month;

    EmplDiv.append(FI);
    EmplDiv.append(O);
    EmplDiv.append(Email);
    EmplDiv.append(Position);
    EmplDiv.append(day);

    EmplDiv.classList.add("EmployeeCard");

    return EmplDiv;
}

async function CreateEventPlitka() {

    const events = await AllEvent();
    const PapaEvent = document.getElementById("PapaEvent");

    for (let item of events) {
        PapaEvent.append(CreateEvent(item));
    }

}

function CreateEvent(event) {

    const EventDiv = document.createElement("div");
    EventDiv.classList.add("EventDiv");

    const name = document.createElement("h5");
    name.textContent = event.name;
    EventDiv.append(name);

    const description = document.createElement("h5");
    description.textContent = event.description;
    EventDiv.append(description);

    const date = new Date(event.dаteTimeEvent);
    console.log(date.getDate());
    console.log(date.getMonth());
    console.log(date.getYear());
    let finalDate;
    if (date.getMonth() + 1 < 10 && dаte.getDate() < 10) {
        finalDate = '0' + date.getDate() + '.0' + (date.getMonth() + 1) + '.' + date.getFullYear();
    } else {
        if (date.getMonth() + 1 < 10) {
            finalDate = date.getDate() + '.0' + (date.getMonth() + 1) + '.' + date.getFullYear();
        } else {
            if (date.getDate() < 10) {
                finalDate = '0' + date.getDate() + '.' + (date.getMonth() + 1) + '.' + date.getFullYear();
            }
        }
    }

    const dаteTimeEvent = document.createElement("p");

    dаteTimeEvent.textContent = parseInt(date.getDate()) + '.' + parseInt(date.getMonth()) + '.' + parseInt(date.getFullYear());

    EventDiv.append(dаteTimeEvent);

    return  EventDiv;

}

async function DisplayEmpl() {
    const Employee = await GetEmpl();
    const DivEmpl = document.getElementById("CardEmpl");

    for (const item of Employee) {
        const Pos = await GetPosition(item.positionId);
        const element = CreateCardEmpl(item, Pos);
        DivEmpl.append(element);
    }
}

async function AllEvent() {
    try {
        const response = await fetch("http://localhost:8080/api/v1/AllEvent");
        const event = response.json();
        return event;
    } catch (error) {
        console.log(error);
        return [];
    }

}

document.addEventListener("DOMContentLoaded", CreateEventPlitka());
document.addEventListener("DOMContentLoaded", DisplayEmpl());