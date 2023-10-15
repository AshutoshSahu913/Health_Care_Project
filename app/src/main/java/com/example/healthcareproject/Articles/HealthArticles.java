package com.example.healthcareproject.Articles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticles extends AppCompatActivity {
    private final String[][] health_details = {
            {"Walking Daily", "Click more Details"},
            {"Home care of COVID-19", "Click more Details"},
            {"Stop Smoking", "Click more Details"},
            {"Menstrual Cramps", "Click more Details"},
            {"Healthy Gut", "Click more Details"},
            {"Home Workouts", "Click more Details"},

    };
//    private int []images{
//        R.drawable.doctor,
//    };

    private final String[][] health_details_more = {
            {"Is walking good for you? \nWalking can offer numerous health benefits to people of all ages and fitness levels. It may also help prevent certain diseases and even prolong your life.\n" +
                    "\n" +
                    "Walking is free to do and easy to fit into your daily routine. All you need to start walking is a sturdy pair of walking shoes.Read on to learn about some of the benefits of walking.\n" +
                    "\n" +
                    "1. Burn calories \n" +
                    "Walking can help you burn calories. Burning calories can help you maintain or lose weight.\n" +
                    "\n" +
                    "Your actual calorie burn will depend on several factors, including:\n" +
                    "\n" +
                    "walking speed\n" +
                    "distance covered\n" +
                    "terrain (you’ll burn more calories walking uphill than you’ll burn on a flat surface)\n" +
                    "your weight\n" +
                    "You can determine your actual calorie burn through a calorie calculator. For a general estimate, you can also refer to this chart.\n" +
                    "\n" +
                    "2. Strengthen the heart \n" +
                    "Walking at least 30 minutesTrusted Source a day, five days a week can reduce your risk for coronary heart disease by about 19 percentTrusted Source. And your risk may reduce even more when you increase the duration or distance you walk per day.\n" +
                    "\n" +
                    "3. Can help lower your blood sugar \n" +
                    "Taking a short walk after eating may help lower your blood sugar.\n" +
                    "\n" +
                    "A small study found that taking a 15-minute walk three times a day (after breakfast, lunch, and dinner) improved blood sugar levels more than taking a 45-minute walk at another point during the day.\n" +
                    "\n" +
                    "More research is needed to confirm these findings, though.\n" +
                    "\n" +
                    "Consider making a post-meal walk a regular part of your routine. It can also help you fit exercise in throughout the day.\n" +
                    "\n" +
                    "4. Eases joint pain\n" +
                    "Walking can help protect the joints, including your knees and hips. That’s because it helps lubricate and strengthen the muscles that support the joints.\n" +
                    "\n" +
                    "Walking may also provide benefits for people living with arthritis, such as reducing pain. And walking 5 to 6 miles a week may also help prevent arthritis.\n" +
                    "\n" +
                    "5. Boosts immune function \n" +
                    "Walking may reduce your risk for developing a cold or the flu.\n" +
                    "\n" +
                    "One study tracked 1,000 adults during flu season. Those who walked at a moderate pace for 30 to 45 minutes a day had 43 percent fewer sick days and fewer upper respiratory tract infections overall.\n" +
                    "\n" +
                    "Their symptoms were also lessened if they did get sick. That was compared to adults in the study who were sedentary.\n" +
                    "\n" +
                    "Try to get in a daily walk to experience these benefits. If you live in a cold climate, you can try to walk on a treadmill or around an indoor mall.\n" +
                    "\n" +
                    "RELATED VIDEOS\n" +
                    "\n" +
                    "\n" +
                    "Watch More\n" +
                    "6. Boost your energy \n" +
                    "Going for a walk when you’re tired may be a more effective energy boost than grabbing a cup of coffee.\n" +
                    "\n" +
                    "Walking increases oxygen flow through the body. It can also increase levels of cortisol, epinephrine, and norepinephrine. Those are the hormones that help elevate energy levels.\n" +
                    "\n" +
                    "7. Improve your mood \n" +
                    "Walking can help your mental health. StudiesTrusted Source show it can help reduce anxiety, depression, and a negative mood. It can also boost self-esteem and reduce symptoms of social withdrawal.\n" +
                    "\n" +
                    "To experience these benefits, aim for 30 minutes of brisk walking or other moderate intensity exercise three days a week. You can also break it up into three 10-minute walks.\n" +
                    "\n" +
                    "8. Extend your life\n" +
                    "Walking at a faster pace could extend your life. Researchers found that walking at an average pace compared to a slow pace resulted in a 20 percent reduced risk of overall death.\n" +
                    "\n" +
                    "But walking at a brisk or fast pace (at least 4 miles per hour) reduced the risk by 24 percent. The study looked at the association of walking at a faster pace with factors like overall causes of death, cardiovascular disease, and death from cancer.\n" +
                    "\n" +
                    "9. Tone your legs \n" +
                    "Walking can strengthen the muscles in your legs. To build up more strength, walk in a hilly area or on a treadmill with an incline. Or find routes with stairs.\n" +
                    "\n" +
                    "Also trade off walking with other cross-training activities like cycling or jogging. You can also perform resistance exercises like squats, lunges, and leg curls to further tone and strengthen your leg muscles.\n" +
                    "\n" +
                    "10. Creative thinking \n" +
                    "Walking may help clear your head and help you think creatively.\n" +
                    "\n" +
                    "A study that included four experiments compared people trying to think of new ideas while they were walking or sitting. Researchers found participants did better while walking, particularly while walking outdoors.\n" +
                    "\n" +
                    "The researchers concluded that walking opens up a free flow of ideas and is a simple way to increase creativity and get physical activity at the same time.\n" +
                    "\n" +
                    "Try to initiate a walking meeting with your colleagues the next time you’re stuck on a problem at work.\n" +
                    "\n" +
                    "Tips for staying safe while walking \n" +
                    "To ensure your safety while walking, follow these tips:\n" +
                    "\n" +
                    "Walk in areas designated for pedestrians. Look for well-lit areas if possible.\n" +
                    "If you walk in the evening or early morning hours, wear a reflective vest or light so cars can see you.\n" +
                    "Wear sturdy shoes with good heel and arch support.\n" +
                    "Wear loose, comfortable clothing.\n" +
                    "Drink plenty of water before and after your walk to stay hydrated.\n" +
                    "Wear sunscreen to prevent sunburn, even on cloudy days.\n" +
                    "How to get started\n" +
                    "To get started walking, all you’ll need is a pair of sturdy walking shoes. Choose a walking route near your home. Or look for a scenic place to walk in your area, such as a trail or on the beach.\n" +
                    "\n" +
                    "You can also recruit a friend or family member to walk with you and hold you accountable. Alternatively, you can add walking into your daily routine. Here are some ideas:\n" +
                    "\n" +
                    "If you commute, get off your bus or train one stop early and walk the rest of the way to work.\n" +
                    "Park farther away from your office than usual and walk to and from your car.\n" +
                    "Consider walking instead of driving when you run errands. You can complete your tasks and fit in exercise at the same time.\n"},

            {"How to Manage a Mild Case of COVID-19 at Home It's never fun to be sick, but having COVID-19 can be downright distressing. The fear of the unknown combined with isolation—given the strict directives, even when it comes to members in your household—makes for an overwhelming experience.\n" +
                    "\n" +
                    "Fortunately, most cases of COVID are mild. If you’re weathering the illness at home, here are some strategies you can use to keep others safe and ease your symptoms.\n" +
                    "\n" +
                    " COVID-19: What to Expect If You Get Sick\n" +
                    "How to Isolate at Home\n" +
                    "The Centers for Disease Control and Prevention (CDC) advises that people with a mild case of COVID-19 isolate for 10 days after their symptoms start.1 That means staying home except to get medical care.\n" +
                    "\n" +
                    "According to the CDC, you can end isolation after 10 days if you’ve been fever-free for 24 hours without help from fever-reducing medications and your condition has improved. If you've had severe symptoms or are immunocompromised, you might have to isolate longer.2\n" +
                    "\n" +
                    " Why the CDC Reduced COVID-19 Isolation to 10 Days\n" +
                    "What to Do If You Live with Other People\n" +
                    "It's much easier to keep yourself distanced from others if you live alone, but that might not be the case.\n" +
                    "\n" +
                    "If you have to be in the same room as someone else in your home, you can reduce the risk of spreading the virus to them by both wearing face masks, staying socially distanced, and opening a window.\n" +
                    "\n" +
                    "If there are other people in your household, you'll need to take some steps to avoid transmitting the virus to them while you work on getting better.\n" +
                    "\n" +
                    "Isolate yourself in your own room and use your own bathroom, if possible.\n" +
                    "Have other members of your household leave food, drinks, and other needs at your door rather than going to the kitchen or shared living spaces.\n" +
                    "Consider using disposable dishes, bowls, and flatware.\n" +
                    "Communicate via text or phone. If you’re up for it, you could video chat with FaceTime or Google Hangouts.\n" +
                    "Regularly disinfect surfaces, handles, knobs, and anything else that could potentially be touched in a shared room, such as a bathroom or kitchen (though, again, avoiding communal areas is ideal).\n" +
                    "Wash your hands well with soap and water, and have everyone else in your home do so, too.\n" +
                    " How Long Is COVID-19 Contagious? A Look at the Research\n" +
                    "What If You Live With Others In a Small Space?\n" +
                    "If you live in a small apartment with others, these steps can prove difficult if not impossible. Several U.S. cities, including New York, Baltimore, Chicago, and San Francisco, are offering free hotel stays and meals to people with COVID who do not need hospital care and cannot isolate themselves properly at home.\n" +
                    "\n" +
                    "Tips for Caring for Yourself\n" +
                    "The symptoms and severity of COVID illness can vary widely. Some people have a cough and a headache while others get severely ill and require hospital care. Sometimes, people do not have any symptoms at all.3\n" +
                    "\n" +
                    "If you do get sick and have symptoms, they will likely be mild. You might feel similar to how you'd feel if you had a case of the flu. Common COVID-19 symptoms include:\n" +
                    "\n" +
                    "Fever and chills\n" +
                    "Cough\n" +
                    "Fatigue\n" +
                    "Body aches\n" +
                    "Headache\n" +
                    "Sore throat\n" +
                    "Congestion/runny nose\n" +
                    "Nausea, vomiting, or diarrhea3\n" +
                    "Loss of sense of smell and/or taste\n" +
                    "You might have just a few of these symptoms or a combination of them. While you will likely feel unwell, you probably will not feel sick enough to go to the hospital.\n" +
                    "\n" +
                    " COVID-19 Symptoms May Follow a Specific Order, Study Finds\n" +
                    "Some people with COVID-19 develop trouble breathing. If you start feeling short of breath or like you can't breathe, seek medical care right away.\n" +
                    "\n" +
                    "Managing Your Symptoms at Home\n" +
                    "If you have a mild case of COVID-19, you can use many of the same remedies to feel better that you'd use if you had a cold or the flu.\n" +
                    "\n" +
                    "Elevate Your Head and Upper Body\n" +
                    "When you’re flat on your back, your abdomen pushes up on your diaphragm, which can make it harder to breathe. If you're congested, you'll feel the effect even more.\n" +
                    "\n" +
                    "M. Nadir Bhuiyan, MD, an internist at the Mayo Clinic and co-director of the COVID-19 Frontline Care Team (CFCT) for Mayo Clinic Rochester’s Pandemic Telehealth Response Team, tells Verywell that resting on a slight incline instead may help.\n" +
                    "\n" +
                    "If you have an adjustable frame or recliner, raise the upper portion to elevate your head and upper body. A foam wedge support can also prop you up.\n" +
                    "\n" +
                    " Ask an Infectious Disease Expert: What Causes a Severe Case of COVID-19?\n" +
                    "Change Positions\n" +
                    "COVID-19 can cause trouble breathing, which can be serious. If you are having a hard time breathing at any point in your illness, seek medical help right away. If you just have some mild discomfort—you feel like you aren't taking as deep a breath as you normally do—there are some things you can do for relief.\n" +
                    "\n" +
                    "Gregory M. Schrank, MD, assistant professor of medicine and infectious disease expert at the University of Maryland Medical System, tells Verywell that switching between lying on your stomach and on your side can help with oxygen delivery and comfort.\n" +
                    "\n" +
                    "Do Breathing Exercises\n" +
                    "Breathing exercises have many benefits, even when you're not sick. They can help you take in more oxygen, give your lungs a workout, and can even calm you down.\n" +
                    "\n" +
                    "One technique to try is pursed lips breathing. Schrank says that this exercise “helps to keep your airway open for a longer period of time.\"\n" +
                    "\n" +
                    "Inhale deeply through your nose with your mouth closed.\n" +
                    "Then, pucker your lips (like you’re about to blow out a candle) and breathe out slowly.\n" +
                    "Another technique is belly (or diaphragmatic) breathing:\n" +
                    "\n" +
                    "Place one hand just below your rib cage and the other on your upper chest. Breathe as you would for pursed lips breathing, but focus on the movement of your diaphragm.\n" +
                    "You should feel your belly push against your lower hand as you breathe in, and fall inward as you breathe out. Keep the hand on your upper chest relatively still. \n" +
                    " Breathing Exercises For Chronic COVID-19: What They Are and How They Help\n" +
                    "Stay Hydrated\n" +
                    "Drinking plenty of hydrating fluids is always important, but even more so when you're sick. Symptoms like fever, sweating, vomiting, and diarrhea cause your body to lose water.\n" +
                    "\n" +
                    "Bhuiyan says that while it's OK to hydrate with plain water, your body will absorb the fluid better with some salt or sugar. Warm meat or vegetable broth with a little salt or beverages that have added electrolytes and sugar, like Gatorade or Pedialyte, can help.\n" +
                    "\n" +
                    "Nourish Your Body\n" +
                    "When you're sick, you might not feel hungry. If you have gastrointestinal symptoms, food might be the last thing on your mind. To feel better, though, your body needs proper nourishment.\n" +
                    "\n" +
                    " GI Symptoms May Signal Milder COVID-19 Infection\n" +
                    "“One of the things we worried about with COVID is feeling light-headed and passing out,” Bhuiyan says. “That’s why we encourage people to eat something small, even if they’re not hungry. Clear soups are good because, besides the liquids, you have the fats, proteins, and salts.”\n" +
                    "\n" +
                    "Take OTC Medications\n" +
                    "Over-the-counter (OTC) pain relievers like Tylenol are often enough to treat a mild headache, and also help reduce a fever. Your provider might say that other OTC options, including NSAIDs (nonsteroidal anti-inflammatory drugs) such as ibuprofen (like Advil), are OK to use if you are not at risk for gastrointestinal bleeding and you do not have kidney problems.\n" +
                    "\n" +
                    "If you have a cough, OTC remedies can help your symptoms. However, Bhuiyan warns that some of these products, such as Benadryl, contain antihistamines and can make you drowsy. Time your dose for about half an hour before bedtime.\n" +
                    "\n" +
                    "Rest\n" +
                    "Bhuiyan says that people who have COVID-19 are often surprised by the fatigue and lack of energy they experience. Rest is one of the best things you can do for your body.\n" +
                    "\n" +
                    "If you are having a hard time falling asleep, Bhuiyan suggests asking your provider if a melatonin supplement might help.\n" +
                    "\n" +
                    "While melatonin is generally safe for short-term use, the supplements can cause side effects and interact with certain medications. Make sure to talk to your doctor before taking them.\n" +
                    "\n" +
                    "Move Around\n" +
                    "While you need your rest, you also don't want to be completely immobile while you recover. \"Lying in bed all day is not a means for a quick recovery,” Schrank says. “When you lie in bed for an extended period of time, you don’t let the lungs expand and work to their fullest capacity, and this can perpetuate a feeling of fatigue.”\n" +
                    "\n" +
                    "In addition to your breathing exercises, make it a goal to walk around a little each day. If you live alone, you can move around your house. but even just staying active by walking around in your room can help.\n" +
                    "\n" +
                    "What This Means for You\n" +
                    "If you have a mild case of COVID-19, stay away from other people—including the people you live with. Rest, hydration, and breathing exercises can help. Keep track of how you're feeling and if your symptoms are not getting better, or are getting worse, call your doctor or seek emergency care.\n" +
                    "\n" +
                    "How to Monitor Your Symptoms \n" +
                    "Monitoring your symptoms can help you gauge whether you’re on the mend or in need of medical care. Your provider and local health department will likely provide specific instructions, but consider keeping track of the following:\n" +
                    "\n" +
                    "Take Your Temperature\n" +
                    "Seeing whether you have a fever (and if it's getting better) will be part of your routine if you have COVID. Here are a few best practices to keep in mind.\n" +
                    "\n" +
                    "If you’ve just taken a pain reliever, wait at least six hours before taking your temperature to get the most accurate reading.\n" +
                    "If you’re using an oral thermometer and you’ve been eating or drinking—particularly anything hot or cold—wait half an hour before taking your temperature.\n" +
                    "Check Your Oxygen Level\n" +
                    "A pulse oximeter can tell you a little about how well your lungs are working. Not everyone with COVID needs to use one, but your provider might suggest it.\n" +
                    "\n" +
                    "The small device clips onto the end of your finger. You press a button and it takes a measurement. Keep in mind that moving too much or wearing nail polish can affect the reading. There is also evidence that the devices sometimes do not work well on darker skin tones.\n" +
                    "\n" +
                    " COVID-19 Symptom Lists and Detection Tools May Exhibit Racial Bias\n" +
                    "“Most healthy individuals with no lung or heart disease will have numbers well above 92%,” Bhuiyan says. If your reading drops below that level, it's time to call your doctor.\n" +
                    "\n" +
                    "If at any point your pulse oximeter reading is under 90%, call 911 or go to your nearest emergency room.\n" +
                    "\n" +
                    "If you don't have an oximeter or you're just too tired to keep track, Schrank suggests asking yourself certain questions throughout the day to assess how you're doing:\n" +
                    "\n" +
                    "Do I feel like today is worse than the day before, or is it better?\n" +
                    "Am I feeling better this afternoon compared to how I felt in the morning?\n" +
                    "Do I feel short of breath today compared to yesterday?\n" +
                    "When to Seek Medical Care\n" +
                    "Mild cases of COVID-19 typically resolve in a week or two. If you're not feeling better, it's time to seek medical care. Many healthcare providers are now offering virtual appointments, which means that you may not have to go into the office unless they want to examine you.\n" +
                    "\n" +
                    " When to Seek Emergency Care During the COVID-19 Pandemic\n" +
                    "In some cases, not feeling better or feeling much worse warrants a trip to the hospital. Here are some symptoms to watch for:\n" +
                    "\n" +
                    "A persistent fever. Schrank says that while a high fever \"isn’t necessarily concerning in and of itself,” if it lingers for days and doesn't go down when you take OTC medication like Tylenol, you need to call your doctor.\n" +
                    "Chest pain. Having chest pain can be a sign of many problems, like blood clots or pneumonia. If you have new chest pain that isn't severe, you should call your provider. If you have severe chest pain, call 911 or go to the emergency room.\n" +
                    "Shortness of breath or difficulty breathing. If you feel as if it’s unusually challenging to get enough air or you’re breathing hard even with only a little exertion, go to the ER.\n" +
                    "Nausea and vomiting. If these symptoms are severe enough that you are having trouble getting nourishment and staying hydrated, you need to let your provider know. They might want you to go to the ER.\n" +
                    "Pale, gray, or blue-colored skin, lips, or nail beds. This serious sign warrants a trip to the ER, as it can mean that your body is not getting enough oxygen. However, you should know that it's not always apparent, depending on your skin tone.\n" +
                    "Suddenly having a hard time walking or feeling confused. Schrank says that these can be symptoms of low oxygen levels or a secondary bacterial infection. Go to the ER right away."},
            {"13 Best Quit-Smoking Tips Ever \n1. Find Your Reason\n" +
                    "1/13\n" +
                    "To get motivated, you need a powerful, personal reason to quit. It may be to protect your family from secondhand smoke.  Or lower your chance of getting lung cancer, heart disease, or other conditions. Or to look and feel younger. Choose a reason that is strong enough to outweigh the urge to light up.\n" +
                    "\n" +
                    "2. Prepare Before You Go 'Cold Turkey'\n" +
                    "2. Prepare Before You Go 'Cold Turkey'\n" +
                    "2/13\n" +
                    "There’s more to it than just tossing your cigarettes out. Smoking is an addiction. The brain is hooked on nicotine. Without it, you’ll go through withdrawal. Line up support in advance. Ask your doctor about all the methods that will help, such as quit-smoking classes and apps, counseling, medication, and hypnosis. You’ll be ready for the day you choose to quit.   \n" +
                    "\n" +
                    "3. Consider Nicotine Replacement Therapy\n" +
                    "3. Consider Nicotine Replacement Therapy\n" +
                    "3/13\n" +
                    "When you stop smoking, nicotine withdrawal may give you headaches, affect your mood, or sap your energy. The craving for “just one drag” is tough. Nicotine replacement therapy can curb these urges. Studies show that nicotine gum, lozenges, and patches improve your chances of success when you’re also in a quit-smoking program.\n" +
                    "\n" +
                    "4. Learn About Prescription Pills\n" +
                    "4. Learn About Prescription Pills\n" +
                    "4/13\n" +
                    "Medicines can curb cravings and may also make smoking less satisfying if you do pick up a cigarette. Other drugs can ease withdrawal symptoms, such as depression or problems with concentration.\n" +
                    "\n" +
                    "5. Lean On Your Loved Ones\n" +
                    "5. Lean On Your Loved Ones\n" +
                    "5/13\n" +
                    "Tell your friends, family, and other people you’re close to that you’re trying to quit. They can encourage you to keep going, especially when you’re tempted to light up. You can also join a support group or talk to a counselor. Behavioral therapy is a type of counseling that helps you identify and stick to quit-smoking strategies. Even a few sessions may help.  \n" +
                    "\n" +
                    "6. Give Yourself a Break\n" +
                    "6. Give Yourself a Break\n" +
                    "6/13\n" +
                    "One reason people smoke is that the nicotine helps them relax. Once you quit, you’ll need new ways to unwind. There are many options. You can exercise to blow off steam, tune in to your favorite music, connect with friends, treat yourself to a massage, or make time for a hobby. Try to avoid stressful situations during the first few weeks after you stop smoking.\n" +
                    "\n" +
                    "7. Avoid Alcohol and Other Triggers\n" +
                    "7. Avoid Alcohol and Other Triggers\n" +
                    "7/13\n" +
                    "When you drink, it’s harder to stick to your no-smoking goal. So try to limit alcohol when you first quit. Likewise, if you often smoke when you drink coffee, switch to tea for a few weeks. If you usually smoke after meals, find something else to do instead, like brushing your teeth, taking a walk, texting a friend, or chewing gum.\n" +
                    "\n" +
                    "8. Clean House\n" +
                    "8. Clean House\n" +
                    "8/13\n" +
                    "Once you’ve smoked your last cigarette, toss all of your ashtrays and lighters. Wash any clothes that smell like smoke, and clean your carpets, draperies, and upholstery. Use air fresheners to get rid of that familiar scent. If you smoked in your car, clean it out, too. You don’t want to see or smell anything that reminds you of smoking.\n" +
                    "\n" +
                    "9. Try and Try Again\n" +
                    "9. Try and Try Again\n" +
                    "9/13\n" +
                    "Many people try several times before giving up cigarettes for good. If you light up, don’t get discouraged. Instead, think about what led to your relapse, such as your emotions or the setting you were in. Use it as an opportunity to step up your commitment to quitting. Once you’ve made the decision to try again, set a “quit date” within the next month.\n" +
                    "\n" +
                    "10. Get Moving\n" +
                    "10. Get Moving\n" +
                    "10/13\n" +
                    "Being active can curb nicotine cravings and ease some withdrawal symptoms. When you want to reach for a cigarette, put on your inline skates or jogging shoes instead. Even mild exercise helps, such as walking your dog or pulling weeds in the garden. The calories you burn will also ward off weight gain as you quit smoking.\n" +
                    "\n" +
                    "11. Eat Fruits and Veggies\n" +
                    "11. Eat Fruits and Veggies\n" +
                    "11/13\n" +
                    "Don’t try to diet while you give up cigarettes. Too much deprivation can easily backfire. Instead, keep things simple and try to eat more fruits, vegetables, whole grains, and lean protein. These are good for your whole body.\n" +
                    "\n" +
                    "12. Choose Your Reward\n" +
                    "12. Choose Your Reward\n" +
                    "12/13\n" +
                    "In addition to all the health benefits, one of the perks of giving up cigarettes is all the money you will save. There are online calculators that figure out how much richer you will be. Reward yourself by spending part of it on something fun.\n" +
                    "\n" +
                    "13. Remember That Time Is on Your Side\n" +
                    "13. Remember That Time Is on Your Side\n" +
                    "13/13\n" +
                    "As soon as you quit, you start to get immediate health benefits. After only 20 minutes, your heart rate goes back to normal. Within a day, your blood’s carbon monoxide level also falls back into place. In just 2-3 weeks, you will start to lower your odds of having a heart attack. In the long run, you will also lower your chance of getting lung cancer and other cancers.\n"},
            {"# Understanding Menstrual Cramps: Causes, Symptoms, and Relief\n" +
                    "\n" +
                    "Menstrual cramps, scientifically referred to as dysmenorrhea, are a common discomfort experienced by individuals assigned female at birth during their menstrual cycle. These cramps usually occur just before and during menstruation.\n" +
                    "\n" +
                    "## **Causes**\n" +
                    "\n" +
                    "The primary cause of menstrual cramps is the contraction of the uterus. The uterus contracts to help shed its lining during menstruation. The intensity of these contractions can cause pain and discomfort.\n" +
                    "\n" +
                    "Other contributing factors to menstrual cramps include:\n" +
                    "\n" +
                    "1. **Prostaglandins**: These hormone-like substances promote uterine contractions to shed the uterine lining. Higher levels of prostaglandins can result in more severe menstrual cramps.\n" +
                    "\n" +
                    "2. **Hormonal Changes**: Fluctuations in hormone levels, particularly estrogen and progesterone, play a role in the severity of menstrual cramps.\n" +
                    "\n" +
                    "3. **Pelvic Inflammatory Disease (PID)**: Infections in the reproductive organs, such as PID, can lead to painful menstrual cramps.\n" +
                    "\n" +
                    "4. **Endometriosis**: This condition occurs when tissue similar to the uterine lining grows outside the uterus, causing severe menstrual pain.\n" +
                    "\n" +
                    "## **Symptoms**\n" +
                    "\n" +
                    "Common symptoms of menstrual cramps include:\n" +
                    "\n" +
                    "- **Dull or throbbing pain in the lower abdomen**: This pain can range from mild to severe.\n" +
                    "  \n" +
                    "- **Lower back and pelvic pain**: The pain may radiate to the lower back and thighs.\n" +
                    "\n" +
                    "- **Nausea and vomiting**: Some individuals may experience gastrointestinal symptoms along with menstrual cramps.\n" +
                    "\n" +
                    "- **Headaches and dizziness**: These symptoms can be associated with severe menstrual cramps.\n" +
                    "\n" +
                    "## **Management and Relief**\n" +
                    "\n" +
                    "While menstrual cramps can be uncomfortable, several strategies can help manage the pain and discomfort:\n" +
                    "\n" +
                    "1. **Pain Relief Medications**: Over-the-counter pain relievers like ibuprofen, aspirin, or naproxen sodium can help alleviate cramp pain.\n" +
                    "\n" +
                    "2. **Heat Therapy**: Applying a heating pad or hot water bottle to the abdomen can relax the muscles and provide relief.\n" +
                    "\n" +
                    "3. **Exercise**: Regular physical activity can help reduce the severity and duration of menstrual cramps.\n" +
                    "\n" +
                    "4. **Dietary Changes**: Avoiding caffeine, alcohol, and salty foods can help minimize bloating and discomfort.\n" +
                    "\n" +
                    "5. **Relaxation Techniques**: Practicing relaxation techniques such as yoga, deep breathing, or meditation can help manage stress and reduce cramps.\n" +
                    "\n" +
                    "If menstrual cramps are severe and significantly impact daily life, it's advisable to consult a healthcare professional for further evaluation and potential treatment options.\n" +
                    "\n" +
                    "In conclusion, menstrual cramps are a common part of the menstrual cycle for many individuals. Understanding the causes, symptoms, and effective management strategies can help individuals navigate this natural aspect of reproductive health."},
            {"# Exploring a Healthy Gut: Importance, Tips, and Foods for Gut Health\n" +
                    "\n" +
                    "A healthy gut is fundamental to overall well-being, as it plays a crucial role in digestion, nutrient absorption, and supporting the immune system. Maintaining a healthy gut involves a combination of a balanced diet, lifestyle choices, and proper hydration. Here's an exploration of the importance of a healthy gut, tips to maintain gut health, and foods that promote gut health.\n" +
                    "\n" +
                    "## **Importance of a Healthy Gut**\n" +
                    "\n" +
                    "A healthy gut is linked to various aspects of health, including:\n" +
                    "\n" +
                    "1. **Digestive Health**: A healthy gut aids in proper digestion and helps prevent digestive issues such as constipation, diarrhea, and bloating.\n" +
                    "\n" +
                    "2. **Immune Function**: A significant portion of the immune system is located in the gut. A healthy gut supports a strong immune response and helps fight off infections.\n" +
                    "\n" +
                    "3. **Mental Health**: The gut-brain connection is well-established. A healthy gut can positively impact mental health, reducing the risk of anxiety and depression.\n" +
                    "\n" +
                    "4. **Nutrient Absorption**: An optimally functioning gut ensures efficient absorption of essential nutrients from the food we consume.\n" +
                    "\n" +
                    "## **Tips for Maintaining Gut Health**\n" +
                    "\n" +
                    "Here are some tips to promote a healthy gut:\n" +
                    "\n" +
                    "1. **Diverse Diet**: Incorporate a variety of fruits, vegetables, whole grains, legumes, and nuts to provide a broad range of nutrients and fiber that support gut health.\n" +
                    "\n" +
                    "2. **Probiotic-Rich Foods**: Include fermented foods like yogurt, kefir, sauerkraut, and kimchi in your diet. These foods are rich in probiotics, which are beneficial for gut bacteria.\n" +
                    "\n" +
                    "3. **Prebiotic Foods**: Consume foods rich in prebiotic fibers, such as onions, garlic, bananas, asparagus, and whole grains. Prebiotics feed the beneficial gut bacteria.\n" +
                    "\n" +
                    "4. **Hydration**: Drink plenty of water to maintain proper gut hydration and support digestive processes.\n" +
                    "\n" +
                    "5. **Manage Stress**: Chronic stress can negatively impact gut health. Practice stress-reducing techniques like meditation, deep breathing, or yoga.\n" +
                    "\n" +
                    "6. **Limit Processed Foods and Sugar**: Excessive consumption of processed foods and sugary items can disrupt gut bacteria balance. Limit their intake for a healthier gut.\n" +
                    "\n" +
                    "7. **Regular Exercise**: Engage in regular physical activity, as it supports gut motility and overall well-being.\n" +
                    "\n" +
                    "## **Foods for Gut Health**\n" +
                    "\n" +
                    "1. **Yogurt**: A rich source of probiotics that aid in maintaining a healthy gut microbiome.\n" +
                    "\n" +
                    "2. **Fiber-Rich Foods**: Include fruits, vegetables, whole grains, and legumes to promote regular bowel movements and a healthy gut.\n" +
                    "\n" +
                    "3. **Kombucha**: A fermented tea that contains probiotics and beneficial organic acids.\n" +
                    "\n" +
                    "4. **Kimchi and Sauerkraut**: Fermented vegetables that are rich in probiotics and fiber.\n" +
                    "\n" +
                    "5. **Bone Broth**: Contains amino acids and collagen, which can support gut health.\n" +
                    "\n" +
                    "6. **Fruits and Vegetables**: A variety of colorful, non-starchy fruits and vegetables provide essential vitamins, minerals, and fiber.\n" +
                    "\n" +
                    "## **In Conclusion**\n" +
                    "\n" +
                    "Cultivating a healthy gut through a balanced diet, lifestyle choices, and mindful eating is pivotal for overall health. By incorporating probiotic-rich foods, prebiotic fibers, and a diverse range of nutritious foods, you can support your gut and enhance your well-being. It's essential to consult a healthcare professional for personalized advice on maintaining a healthy gut.\n"},
            {"# Effective Home Workouts: Tips and Exercises for a Fit You\n" +
                    "\n" +
                    "Whether you're short on time, prefer the convenience of exercising at home, or are looking for a budget-friendly fitness routine, home workouts can be a great way to achieve your fitness goals. In this article, we'll explore tips for effective home workouts and suggest a variety of exercises you can do in the comfort of your home.\n" +
                    "\n" +
                    "## **Tips for Effective Home Workouts**\n" +
                    "\n" +
                    "1. **Designate a Workout Space**: Choose an area in your home where you can exercise comfortably without distractions. Make sure it's well-ventilated and has enough space for your movements.\n" +
                    "\n" +
                    "2. **Set a Schedule**: Establish a regular workout schedule to maintain consistency. Treat your home workout like any other important appointment.\n" +
                    "\n" +
                    "3. **Warm-Up and Cool Down**: Always start with a proper warm-up and end with a cool down to prevent injuries and enhance flexibility.\n" +
                    "\n" +
                    "4. **Incorporate Variety**: Mix up your workouts to keep things interesting and target different muscle groups. Include strength training, cardiovascular exercises, and flexibility exercises.\n" +
                    "\n" +
                    "5. **Use Your Body Weight**: Bodyweight exercises like push-ups, squats, and lunges can be highly effective and require no equipment.\n" +
                    "\n" +
                    "6. **Include Strength Training**: Incorporate resistance exercises using resistance bands, dumbbells, or household items like water bottles or backpacks filled with books.\n" +
                    "\n" +
                    "7. **Stay Hydrated**: Drink water before, during, and after your workout to stay hydrated and maintain energy levels.\n" +
                    "\n" +
                    "8. **Monitor Progress**: Keep a record of your workouts, noting the exercises, sets, reps, and weights used. Tracking progress can motivate you to stay on track.\n" +
                    "\n" +
                    "## **Home Workout Exercises**\n" +
                    "\n" +
                    "### 1. **Bodyweight Exercises:**\n" +
                    "\n" +
                    "- **Push-Ups**: Targets chest, shoulders, and triceps.\n" +
                    "  \n" +
                    "- **Squats**: Works the quadriceps, hamstrings, and glutes.\n" +
                    "  \n" +
                    "- **Plank**: Engages the core muscles and improves stability.\n" +
                    "  \n" +
                    "- **Jumping Jacks**: Great for a cardiovascular workout and warming up.\n" +
                    "\n" +
                    "### 2. **Cardiovascular Exercises:**\n" +
                    "\n" +
                    "- **High Knees**: Run in place, bringing your knees as high as possible.\n" +
                    "  \n" +
                    "- **Burpees**: Full-body exercise that combines squats, push-ups, and jumps.\n" +
                    "  \n" +
                    "- **Mountain Climbers**: Engages the core and provides a good cardio workout.\n" +
                    "  \n" +
                    "- **Jump Rope**: A classic and effective cardiovascular exercise.\n" +
                    "\n" +
                    "### 3. **Strength Training Exercises:**\n" +
                    "\n" +
                    "- **Dumbbell Lunges**: Works the lower body and helps build leg strength.\n" +
                    "  \n" +
                    "- **Bent-Over Rows**: Targets the back, shoulders, and arms using weights or household items.\n" +
                    "  \n" +
                    "- **Bodyweight Triceps Dips**: Works the triceps using a sturdy chair or bench.\n" +
                    "  \n" +
                    "- **Glute Bridges**: Strengthens the glutes and lower back.\n" +
                    "\n" +
                    "### 4. **Flexibility and Mobility Exercises:**\n" +
                    "\n" +
                    "- **Yoga Poses**: Incorporate poses like Downward Dog, Cat-Cow, and Child's Pose for flexibility and relaxation.\n" +
                    "  \n" +
                    "- **Static Stretching**: Stretch major muscle groups to improve flexibility and reduce muscle tension.\n" +
                    "\n" +
                    "Remember to tailor your workouts to your fitness level and gradually progress to more challenging exercises. Listen to your body, and if you experience pain or discomfort during any exercise, stop and consult a healthcare professional.\n" +
                    "\n" +
                    "## **Conclusion**\n" +
                    "\n" +
                    "Home workouts can be an effective and convenient way to stay fit and active. By incorporating a variety of exercises, focusing on proper form, and staying consistent with your routine, you can achieve your fitness goals within the comfort of your home.\n"}

    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lstView;
    ImageView backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);
        backToHome = findViewById(R.id.backToHomeHA);
        backToHome.setOnClickListener(view -> startActivity(new Intent(HealthArticles.this, HomePage.class)));


        /*--------------------------------------Set The data form list View  ----------------------------------------------------------------------------------------*/
        lstView = findViewById(R.id.healthArticlesList);
        list = new ArrayList<>();
        for (String[] healthDetail : health_details) {
            item = new HashMap<>();
            item.put("line1", healthDetail[0]);
            item.put("line2", healthDetail[1]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.articles_list,
                new String[]{"line1", "line2"},
                new int[]{R.id.line_p, R.id.line_q}
        );
        lstView.setAdapter(sa);

        lstView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(HealthArticles.this, HealthArticlesDetails.class);
            it.putExtra("text1", health_details[i][0]);
            it.putExtra("text2", health_details_more[i]);
            startActivity(it);
        });
    }
}