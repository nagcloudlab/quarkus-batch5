package com.examples;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

class TrainerModule {

	public Observable<String> getTopics() {
		Observable<String> stream = Observable.create(e -> {
			int i = 0;
			Random random = new Random();
			while (i <= 4) {
				TimeUnit.SECONDS.sleep(2);

				e.onNext("topic-" + i);

//				if (random.nextBoolean()) {
//					e.onError(new IllegalStateException("nw issue"));
//					return;
//				}

				i++;
			}
			e.onComplete();
		});
		return stream;
	}

}

class ParticipantModule {

	TrainerModule trainerModule = new TrainerModule();

	public void doLearn() {
		Observable<String> observable = trainerModule.getTopics();
		observable
		.filter(topic->!topic.equals("topic-3"))
		.map(topic->topic.toUpperCase())
		.subscribe(nextTopic -> {
			System.out.println("Learning " + nextTopic);
		}, error -> {
			System.out.println("let wait to resolve nw issue");
		}, () -> {
			System.out.println("thanks");
		});
	}
}

public class Ex2 {
	public static void main(String[] args) {

		ParticipantModule participantModule = new ParticipantModule();
		participantModule.doLearn();

	}
}
