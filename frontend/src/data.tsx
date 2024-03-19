type QuestionAnswer ={
    id: number,
    question:string,
    answer1:string,
    answer2:string,
    answer3: string,
}

const mockData:QuestionAnswer[] = [

    {
        id: 1,
        question: "Delivering Value!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",
        answer1: "We deliver great stuff! We're proud of it and our stakeholders are really happy.",
        answer2: "Neutral.",
        answer3: "We deliver crap. We feel ashamed to deliver it. Our stakeholders hate us."
    },
    {
        id: 2,
        question: "Easy to release",
        answer1: "Releasing is simple, safe, painless and mostly automated.",
        answer2: "Neutral.",
        answer3: "Releasing is risky, painful, lots of manual work and takes forever."
    },
    {
        id: 3,
        question: "Day by day work",
        answer1: "We love going to work and have great fun working together!",
        answer2: "Neutral.",
        answer3: "Boooooooring..."
    },
    {
        id: 4,
        question: "Learning and Growth",
        answer1: "We're learning lots of interesting stuff all the time! I feel I growth on my career.",
        answer2: "Neutral.",
        answer3: "We never have time to learn anything."
    },
    {
        id: 5,
        question: "VW Digital Hub",
        answer1: "We know exactly why we are here and we’re really excited about it!",
        answer2: "Neutral.",
        answer3: "We have no idea why we are here, there's no high lever picture or focus. Our so called mission is completely unclear and uninspiring."
    },
    {
        id: 6,
        question: "Pawns or Players",
        answer1: "We are in control of our own destiny! We decide what to build and how to build it.",
        answer2: "Neutral.",
        answer3: "We are just pawns in a game of chess with no influence over what we build or how we build it."
    } 

]
export default mockData;