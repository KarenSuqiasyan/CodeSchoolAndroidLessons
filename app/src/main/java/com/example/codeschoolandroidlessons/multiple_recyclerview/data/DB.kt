package com.example.codeschoolandroidlessons.multiple_recyclerview.data

import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.ImagePost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.TextPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.UrlPost
import com.example.codeschoolandroidlessons.multiple_recyclerview.data.model.VideoPost

object DB {
    private val items = mutableListOf<Any>()

    fun getData(): MutableList<Any> {
        items.add(TextPost("Liverpool F.C. was founded following a dispute between the Everton committee and John Houlding, club president and owner of the land at Anfield. After eight years at the stadium, Everton relocated to Goodison Park in 1892 and Houlding founded Liverpool F.C. to play at Anfield.[3] Originally named \"Everton F.C. and Athletic Grounds Ltd\" (Everton Athletic for short), the club became Liverpool F.C. in March 1892 and gained official recognition three months later, after The Football Association refused to recognise the club as Everton.[4]\n" +
                "\n" +
                "Liverpool played their first match on 1 September 1892, a pre-season friendly match against Rotherham Town, which they won 7–1. The team Liverpool fielded against Rotherham was composed entirely of Scottish players – the players who came from Scotland to play in England in those days were known as the Scotch Professors. Manager John McKenna had recruited the players after a scouting trip to Scotland – so they became known as the \"team of Macs\".[5] The team won the Lancashire League in its debut season and joined the Football League Second Division at the start of the 1893–94 season. After the club was promoted to the First Division in 1896, Tom Watson was appointed manager. He led Liverpool to its first league title in 1901, before winning it again in 1906.[6]\n" +
                "\n" +
                "Liverpool reached its first FA Cup Final in 1914, losing 1–0 to Burnley. It won consecutive League championships in 1922 and 1923, but did not win another trophy until the 1946–47 season, when the club won the First Division for a fifth time under the control of ex-West Ham United centre half George Kay.[7] Liverpool suffered its second Cup Final defeat in 1950, playing against Arsenal.[8] The club was relegated to the Second Division in the 1953–54 season.[9] Soon after Liverpool lost 2–1 to non-league Worcester City in the 1958–59 FA Cup, Bill Shankly was appointed manager. Upon his arrival he released 24 players and converted a boot storage room at Anfield into a room where the coaches could discuss strategy; here, Shankly and other \"Boot Room\" members Joe Fagan, Reuben Bennett, and Bob Paisley began reshaping the team.[10]"))
        items.add(VideoPost("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4"))
        items.add(VideoPost("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"))
        items.add(UrlPost("https://films.bz/serial/136-anamotnery.html", "https://films.bz/uploads/posts/2019-08/1566060675_xad17f3cf3064ak36a93r.jpg"))
        items.add(ImagePost("https://media.istockphoto.com/vectors/vector-flag-of-brazil-proportion-710-brazilian-national-flag-vector-id967321044?k=20&m=967321044&s=612x612&w=0&h=PiLcSCJ7UzJkXOC3RhNw4WUQouAUwmkms5m7F7Ff9qA="))
        items.add(UrlPost("https://films.bz/serial/29836-friends.html", "https://films.bz/uploads/posts/2020-02/1582461532_06a80g864dfh86ghj86gh86k40h8460j8460df4860dfhnjfh.jpg"))
        items.add(ImagePost("https://thumbs.dreamstime.com/z/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg"))
        items.add(ImagePost("https://thumbs.dreamstime.com/z/landscape-nature-mountan-alps-rainbow-76824355.jpg"))
        items.add(TextPost("Real Madrid Club de Fútbol (Spanish pronunciation: [reˈal maˈðɾið ˈkluβ ðe ˈfuðβol] (listen), meaning Royal Madrid Football Club), commonly referred to as Real Madrid,[note 1] is a Spanish professional football club based in Madrid.\n" +
                "\n" +
                "Founded in 1902 as Madrid Football Club, the club has traditionally worn a white home kit since its inception. The honorific title real is Spanish for \"royal\" and was bestowed to the club by King Alfonso XIII in 1920 together with the royal crown in the emblem. Real Madrid have played their home matches in the 81,044-capacity Santiago Bernabéu Stadium in downtown Madrid since 1947. Unlike most European sporting entities, Real Madrid's members (socios) have owned and operated the club throughout its history.\n" +
                "\n" +
                "Real Madrid is one of the most widely supported teams internationally.[6] The club was estimated to be worth \$5.1 billion in 2022, making it the world's most valuable football team.[7] In 2021, it was the second highest-earning football club in the world, with an annual revenue of €640.7 million.[8]"))
        return items
    }
}