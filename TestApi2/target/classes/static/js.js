async function AllEmpl() {
    try {
        const res = await fetch("http://localhost:8080/web/sotrudniki");
        const AllEmpl = res.json();
        return AllEmpl;
    } catch (error) {
        console.error(error);
        return [];
    }
}

async function PositionEmpl(idEmpl) {
    try {
        const res = await fetch("http://localhost:8080/web/getPosition" + "?id=" + idEmpl);
        const Position = res.json();
        return Position;
    } catch (error) {
        console.error(error);
        return [];
    }
}

function CreteCardEmpl(el, pos) {

    const card = document.createElement("div");

    card.classList.add("employee");

    const FI = document.createElement("p");
    FI.textContent = el.familiya + " " + el.imya;

    const pozi = document.createElement("p");
    pozi.textContent = pos.nazvaniye;

    card.append(FI);
    card.append(pozi);

    return card;

}

async function CreateEmplCard() {

    const carusel = document.getElementById("carusel");
    const empl = await AllEmpl();

    for (const el of empl) {
        const pos = await PositionEmpl(el.idSotridnik);
        const card = CreteCardEmpl(el, pos);
        carusel.append(card);
    }

}

async function AllEvent() {
    try {
        const res = await fetch("http://SRV-1208-1:8080/events");
        const AllEvent = await res.json();
        return AllEvent;
    } catch (error) {
        console.error(error);
        return [];
    }

}

async function CreateCardEvent(event) {

    const cardEvent = document.createElement("div");

    cardEvent.classList.add("eventC");

    const description = document.createElement("p");
    description.textContent = event.description;

    cardEvent.append(description);

    return cardEvent;
}

async function CreateEventCards() {
    const carusel = document.getElementById("Event");

    const event = await AllEvent();

    for (const item of event) {
        const cardEvent = await CreateCardEvent(item);
        carusel.append(cardEvent);
    }
}

async function AllNews() {
    try {
        const res = await fetch("http://SRV-1208-1:8080/newsrss");
        const xlm = await res.text();

        const parser = new DOMParser();
        const xlmDoc = parser.parseFromString(xlm, "application/xml");

        const items = xlmDoc.querySelectorAll("item");
        const news = document.getElementById("news");

        for (const item of items) {
            const card = document.createElement("div");
            card.classList.add("newsCard");

            const img = document.createElement("div");
            img.classList.add("img");

            const text = document.createElement("div");
            const title = item.querySelector("title").textContent;
            const titleP = document.createElement("p");
            titleP.textContent = title;
            text.append(titleP);

            card.append(img);
            card.append(text);
            news.append(card);
        }
    } catch (error) {
        console.error(error);
    }

}

document.addEventListener("DOMLoadedContent", CreateEventCards());
document.addEventListener("DOMLoadedContent", CreateEmplCard());
document.addEventListener("DOMLoadedContent", AllNews());