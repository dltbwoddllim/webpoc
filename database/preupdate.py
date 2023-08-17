input_text = """
<h1>friend.tech: The Crypto-Twin of Clubhouse</h1>
    <p>Remember when everyone went crazy over Clubhouse's invite-only strategy? Meet its cooler, crypto-twin: friend.tech.</p>

    <p>In an unexpected turn of events, friend.tech has surpassed OpenSea in daily transactions with 4,400 ETH ($8M+).</p>

    <p>But don't let its intriguing slogan "The marketplace for your friends" lead you astray. Let's delve into what friend.tech really offers and its implications.</p>

    <h2>🤖 So, what's the hype?</h2>
    <p>Launching on the Base blockchain, Friend.tech adopts an exclusive invite-only approach, reminiscent of Clubhouse's early strategy.</p>
    <p>But here's the twist: it's focused on tokenizing well-known crypto personalities. By purchasing shares of these figures, users gain access to private conversations with them.</p>

    <h2>💹 Stonks or people?</h2>
    <p>Just like trading Apple or Tesla stocks, these "people shares" have prices that swing with demand. Spot the next Elon of the crypto world, buy low, and you can watch your investment skyrocket.</p>

    <h2>🐦 Twitter's new obsession</h2>
    <p>What's more, its unique offering has set Crypto Twitter abuzz. The platform's allure for crypto influencers, allowing them to monetize interactions with followers, has undoubtedly added fuel to the fire.</p>

    <h2>🚫 But... pause for thought</h2>
    <p>As with any new venture in the crypto space, it's crucial to exercise due diligence. Several concerns surrounding friend.tech have emerged:</p>
    <ul>
        <li>The value of private chat access remains questionable—what if the influencer is too busy to ever reply?</li>
        <li>The absence of foundational documents like roadmaps and whitepapers</li>
        <li>Users have pointed out technical glitches and delays within the app</li>
        <li>Data privacy remains ambiguous with a "Coming soon!" tag on its privacy policy</li>
    </ul>

    <h2>⚠️ Tread carefully</h2>
    <p>Should you decide to explore friend.tech, it's advisable to prioritize security. Use a discrete email not associated with other critical accounts and ensure to use a fresh wallet funded from a CEX.</p>

    <p>In conclusion, while friend.tech is undoubtedly creating waves, it's essential to navigate its waters with caution and informed decision-making.</p>"""
output_text = input_text.replace('"', "'")
output_text = output_text.replace("\n",' ')

print(output_text)

# save as .sql
# with open('data.sql', 'w') as f:
#     f.write(output_text)

# import mysql.connector

# # MySQL connection parameters
# db_config = {
#     "host": "root",
#     "password": "aimedyohan",
#     "database": "donut"
# }

# html_content = "<div><p>This is some HTML content.</p></div>"

# # Establishing the connection
# connection = mysql.connector.connect(**db_config)
# cursor = connection.cursor()

# # Storing HTML content in the database
# insert_query = "UPDATE title html_data (content) VALUES (%s)"
# cursor.execute(insert_query, (html_content,))
# connection.commit()

# # Closing the connection
# cursor.close()
# connection.close()